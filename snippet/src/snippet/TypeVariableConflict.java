package snippet;

public final class TypeVariableConflict {
	public int pred(int Integer)
	{
		return (Integer)-1;
	}
	public int negativeOne()
	{
		return (Integer)(-1);
	}
	public static void main(String[] args) {
		TypeVariableConflict inst=new TypeVariableConflict();
		System.out.println(inst.pred(8));
	}

}
