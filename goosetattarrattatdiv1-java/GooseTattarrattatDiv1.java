import java.util.*;
public class GooseTattarrattatDiv1 {

	public int getmin(String S) {
		int sum=0;
		char[] buf=S.toCharArray();
		while(true){
			boolean palin=true;
			int mindif=-1,min=10000;
			for(int i=0,l=buf.length;i<l/2;i++){
				boolean res=buf[i]==buf[l-1-i];
				palin&=res;
				if(!res){
					int c1=count(buf,buf[i]);
					int c2=count(buf,buf[l-1-i]);
					if(min>c1){
						mindif=i;
						min=c1;
					}
					if(min>c2){
						mindif=l-1-i;
						min=c2;
					}
				}
			}
			if(palin)break;
			//change
			if(mindif==-1){
				throw new Error();
			}
			char fr=buf[mindif],to=buf[buf.length-1-mindif];
			for(int i=0;i<buf.length;i++){
				if(buf[i]==fr){
					buf[i]=to;
				}
			}
			sum+=min;
		}
		return sum;
	}
	static int count(char[] dat,char ch){
		int c=0;
		for(char cq:dat){
			c+=cq==ch?1:0;
		}
		return c;
	}
}
//SRM 589
