public class Sorts{

    public static void printArray(int[]data){
	System.out.print("{");
	for (int i = 0;i<data.length;i++){
	    if (i+1==data.length){
		System.out.print(data[i]);
	    }
	    else{
		System.out.print(data[i]+",");
	    }
	}
	System.out.print("}\n");
    }

    public static void insertion(int[]data){
	for (int i=1;i<data.length;i++){
	    int moving = data[i];
	    int x;
	    for (x=i-1;x>=0 && moving<data[x];x--){
		data[x+1]=data[x];
	    }
	    data[x+1]=moving;
	}
    }

    public static void selection(int[]data){
	for (int i=0;i<data.length-1;i++){
	    int min = data[i];
	    int minIndex = i;
	    for (int k=i+1;k<data.length;k++){
		if (data[k]<min){
		    min=data[k];
		    minIndex=k;
		}

    public static void main(String[]args){
	int[]ary={8,7,1,4,9};
	printArray(ary);
	insertion(ary);
	printArray(ary);
    }
}
