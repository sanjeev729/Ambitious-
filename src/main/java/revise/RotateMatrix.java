package revise;


public class RotateMatrix{
	
	
	
	
	public static void main(String[] args) {
	
		
		int [][] arr={{1,2,3},{4,5,6},{7,8,9}};
		System.out.println("Normal Array");
		for(int r=0;r<arr.length;r++){
			for(int c=0;c<arr[0].length;c++){
				System.out.print(" " + arr[r][c] + " ");
			}
			System.out.println();
		}
		
		System.out.println("Array rotated 180");
		for(int r=0;r<arr.length;r++){
			for(int c=arr[0].length -1 ;c>=0;c--){
				System.out.print(" " + arr[r][c] + " ");
			}
			System.out.println();
		}
		
		System.out.println("Array rotated 90");
		for(int r=0;r<arr.length;r++){
			for(int c=arr[0].length -1 ;c>=0;c--){
				System.out.print(" " + arr[r][c] + " ");
			}
			System.out.println();
		}
		
		
	
	
	}
	
	
}
