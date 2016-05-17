/*
 There are a total of n courses you have to take, labeled from 0 to n - 1 .
Some courses may have prerequisites, for example to take course 0 you have to
first take course 1, which is expressed as a pair: [0,1]  Given the total number
of courses and a list of prerequisite pairs , is it possible for you to finish
all courses?  For example:  2, [[1,0]]  There are a total of 2 courses to take.
To take course 1 you should have finished course 0. So it is possible.  2,
[[1,0],[0,1]]  There are a total of 2 courses to take. To take course 1 you
should have finished course 0, and to take course 0 you should also have
finished course 1. So it is impossible.  Note: The input prerequisites is a
graph represented by a list of edges , not adjacency matrices. Read more about
how a graph is represented .  click to show more hints.  Hints:   This problem
is equivalent to finding if a cycle exists in a directed graph. If a cycle
exists, no topological ordering exists and therefore it will be impossible to
take all courses.  Topological Sort via DFS - A great video tutorial (21
minutes) on Coursera explaining the basic concepts of Topological Sort.
Topological sort could also be done via BFS .     Subscribe to see which
companies asked this question    Show Tags   Depth-first Search  Breadth-first
Search  Graph  Topological Sort     Show Similar Problems   (M) Course Schedule
II  (M) Graph Valid Tree  (M) Minimum Height Trees
*/


public class Solution {    public boolean canFinish(int numCourses, int[][] prerequisites) {        ArrayList<Integer>[] graph = new ArrayList[numCourses];//graph representing each pairs        int[] degree = new int[numCourses];//in-comming edage records of each vertices        int count = 0;//number of nodes that have no in-comming edages        Queue<Integer> queue = new LinkedList<Integer>();//record of next vertices with no in-comming edage        //init the graph and degree        for(int i=0;i<numCourses;i++){            graph[i] = new ArrayList<Integer>();        }        for(int[] p : prerequisites){            degree[p[1]]++;            graph[p[0]].add(p[1]);        }        //find the first batch of vertices with no in-comming edage        for(int i = 0;i<degree.length;i++){            if(degree[i]==0){                queue.add(i);                count++;            }        }        //BFS search of the graph        while(!queue.isEmpty()){            int t = queue.poll();            System.out.print(t);            for(Integer g:graph[t]){                int p = (int)g;                degree[p]--;                if(degree[p]==0){                   queue.add(p);                   count++;                }            }        }        if(count==numCourses)return true;        else return false;    }}