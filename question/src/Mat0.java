
public class Mat0 {
	int[] array;
	Mat0(int[] ar){
		this.array=ar;
	}
	int solve(){
		return rec(array);
	}
	final int INF=0x3fffff;
	int rec(int[] arg){
		int n=arg.length;
		if(arg.length==2){
			return 0;
		}
		int min=INF;
		int mini=-1;
		for(int i=0;i<arg.length-2;i++){
			int sub1=arg[i]*arg[i+1]*arg[i+2];
			int[] div=new int[n-1];
			for(int j=0;j<n;j++){
				if(j<=i){
					div[j]=arg[j];
				}
				if(j>=i+2){
					div[j-1]=arg[j];
				}
			}
			int sub2=rec(div);
			min=Math.min(min,sub1+sub2);
			if(min==sub1+sub2){
				mini=i;
			}
		}
		System.out.println("("+mini+":"+arg[mini]+","+arg[mini+1]+","+arg[mini+2]+"):"+min);
		return min;
	}
	public static void main(String[] args) {
		Mat0 inst=new Mat0(new int[]{9,3,9,2,4,5});
		System.out.println(inst.solve());
	}

}
