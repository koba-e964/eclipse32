package com.fc2.web.ncneller.wordbook;

import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.widget.TextView;

public final class Usage {
	public static void setText(Resources rsrc,TextView tv,String rsrcStr,String itself)
	{
		if(rsrcStr==null || rsrcStr.length()==0)
		{
			rsrcStr=rsrc.getString(R.string.act2_usage_not_available);
			
		}
		SpannableStringBuilder sb=new SpannableStringBuilder();
		StyleSpan bold=new StyleSpan(Typeface.BOLD);
		for(char c:rsrcStr.toCharArray())
		{
			if(c=='*')	
			{
				int start=sb.length();
				sb.append(itself);
				sb.setSpan(bold, start, sb.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
			}
			else if(c=='_')sb.append(' ');
			else
				sb.append(c);
		}
		tv.setText(sb);
	}
}
