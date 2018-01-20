import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class course_schedule_II {
	public class Solution {
	    public int[] findOrder(int numCourses, int[][] prerequisites) {
	     
	    int[] result = new int[numCourses];
	    int[] preCnt = new int[numCourses];
	    List<Integer>[] nextSet = new List[numCourses];
	    //以每一个节点为起始点，开始做matrix
	    for(int i=0; i<numCourses; i++)
	        nextSet[i] = new ArrayList<>();

	    for(int[] p : prerequisites) {
	        //统计需要每一门预备课出现的次数
	        preCnt[p[0]]++;
	        nextSet[p[1]].add(p[0]);
	    }

	    Queue<Integer> sourceNode = new LinkedList<Integer>();
	    for(int i=0; i<numCourses; i++)
	        if(preCnt[i] == 0)
	            sourceNode.add(i);

	    for(int i=0; i<numCourses; i++) {
	        if(sourceNode.isEmpty())
	            return new int[0];
	        int n = sourceNode.poll();
	        result[i] = n;
	        for(int next : nextSet[n]) {
	            preCnt[next]--;
	            if(preCnt[next] == 0)
	                sourceNode.add(next);
	        }
	    }
	    return result;
	        
	    }
	}

}
