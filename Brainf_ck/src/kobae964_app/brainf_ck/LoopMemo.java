package kobae964_app.brainf_ck;

import java.util.HashMap;
import java.util.Map;

class LoopMemo {
	private Map<Integer,Integer> loopMemo=new HashMap<Integer,Integer>();
	private Map<Integer,Integer> bfVmMap=new HashMap<Integer, Integer>();
	private byte[] program;
	LoopMemo(byte[] p)
	{
		program=p;
	}
	int searchBracket(int pos)
	{
		if(loopMemo.containsKey(pos))
		{
			return loopMemo.get(pos);
		}
		if(program[pos]=='[')
		{
			int st=1;
			for(int i=pos+1;i<program.length;i++)
			{
				if(program[i]=='[')
				{
					st++;
				}
				if(program[i]==']')
				{
					st--;
					if(st==0)
					{
						loopMemo.put(pos, i);
						loopMemo.put(i, pos);
						return i;
					}
				}
			}
			throw new RuntimeException("missing corresponding ']' "+toString());
		}
		if(program[pos]==']')
		{
			int st=1;
			for(int i=pos-1;i>=0;i--)
			{
				if(program[i]==']')
				{
					st++;
				}
				if(program[i]=='[')
				{
					st--;
					if(st==0)
					{
						loopMemo.put(pos, i);
						loopMemo.put(i, pos);
						return i;
					}
				}
			}
			throw new RuntimeException("missing corresponding ']' "+toString());
		}
		throw new RuntimeException("not '[' nor ']' "+toString());

	}
	/**
	 * If searchBracket(pos) is out of [start,end), this method will throw IndexOutOfBoundsException.
	 * Otherwise, returns searchBracket(pos)
	 * @param pos
	 * @param start
	 * @param end
	 * @return
	 */
	int searchBracket(int pos,int start,int end)
	{
		int res=searchBracket(pos);
		if(start>res || res>=end)
		{
			throw new IndexOutOfBoundsException("Corresponding [/] is out of range"+pos+"->"+res);
		}
		return res;
	}
	@Override
	public String toString()
	{
		return loopMemo.toString()+bfVmMap.toString();
	}
}
