package trees;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class VerticalSum {
	Map <Integer,Integer>m = new HashMap<Integer,Integer>();

	public void findVerticalSum(Node root,int level)
	{
		if(root==null)return;
		if(m.containsKey(level))
		{
			
			int temp=m.get(level);
			int sum=temp+root.info;
			m.put(level,sum);
		}
		else
		{
			m.put(level,root.info);
		}
		findVerticalSum(root.left,level-1);
		findVerticalSum(root.right,level+1);
			
	}
	public void print(Node root)
	{
		findVerticalSum(root,0);
		Set<Map.Entry<Integer, Integer>> es = m.entrySet();
		 for(Map.Entry<Integer, Integer> e:es){
		System.out.println(e.getValue());
		 }
	}
}
