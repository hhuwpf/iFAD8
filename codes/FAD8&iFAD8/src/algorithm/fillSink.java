package algorithm;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


/**
 * remove sinks and depressions with the method of Martz and Garbrecht [1998].
 * @author Pengfei Wu
 * @date 2019.8.8
 */
public class fillSink {
	
	public static double[][] fill(double[][] dem){
		int x=dem.length;
		int y=dem[1].length;
		
		int[][] cum=new int[x][y];
		int[][] dep1=new int[x][y];
		double[][] res=new double[x][y];
		
		int[] a={-1,-1,0,1,1,1,0,-1};
		int[] b={0,1,1,1,0,-1,-1,-1};
		
		
		Queue<block1> priQ=new PriorityQueue<>(11,zComparator);  //优先队列
		
		for(int i=0;i<x;i++){
			cum[i][0]=2;
			cum[i][y-1]=2;
		}
		for(int j=0;j<y;j++){
			cum[0][j]=2;
			cum[x-1][j]=2;
		}
		
		for(int i=1;i<x-1;i++){
			for(int j=1;j<y-1;j++){
				int o=0;
				
				if(dem[i][j]<-9998){
					cum[i][j]=2;
				}else{
					for(int t=0;t<8;t++){
						if(dem[i+a[t]][j+b[t]]<-8000)o++;
						if(o>0){
							priQ.add(new block1(i,j,dem[i][j]));
							cum[i][j]=2;
						}
					}
				}
			}
		}
		
		while(priQ.size()!=0){
			block1 blo=priQ.poll();
			int p=blo.getX();
			int q=blo.getY();
			for(int t=0;t<8;t++){
				if(dem[p+a[t]][q+b[t]]<dem[p][q]+0.0000001 && cum[p+a[t]][q+b[t]]<1){
					dem[p+a[t]][q+b[t]]=dem[p][q]+0.0002;
					cum[p+a[t]][q+b[t]]=3;
					priQ.add(new block1(p+a[t],q+b[t],dem[p+a[t]][q+b[t]]));
					dep1[p+a[t]][q+b[t]]=1;
				}else if(cum[p+a[t]][q+b[t]]<1){
					cum[p+a[t]][q+b[t]]=2;
					priQ.add(new block1(p+a[t],q+b[t],dem[p+a[t]][q+b[t]]));
				}
			}			
		}
		
		int num=0,m=0;
		
		while(num!=0){
			num=0;
			for(int i=1;i<x-1;i++){
				for(int j=1;j<y-1;y++){
					if(dem[i][j]>-8000 && cum[i][j]==3){
						m=0;
						for(int t=0;t<8;t++){
							if(dep1[i+a[t]][j+b[t]]>=dep1[i][j]){
								m++;
							}
							if(m==8){
								dep1[i][j]++;
								num++;
							}
						}
					}					
				}				
			}	
		}
		
		for(int i=0;i<x;i++){
			for(int j=0;j<y;j++){
				res[i][j]=dem[i][j]+0.0001*((double)dep1[i][j]);
				
			}
		}
		return res;
	}
	
	//匿名Comparator实现，用于优先队列中的排序
    public static Comparator<block1> zComparator = new Comparator<block1>(){
        public int compare(block1 c1, block1 c2) {
        	return  (int) ((c1.getZ() - c2.getZ())*1000);
        }
    };

}
