package com.fc2.web.ncneller.wordbook;


public class Exam {
	int diff;
	public Exam(int diff)
	{
		if(diff<1 || diff>4)
		{
			throw new IllegalArgumentException("diff(difficulty) must be in [1,4] @ Exam.Exam(int)");
		}
		this.diff=diff;
	}
	public String next()
	{
		count++;
		return Integer.toString(count);
	}
	public boolean hasNext()
	{
		return count<2;
	}
	int count=0;
}
