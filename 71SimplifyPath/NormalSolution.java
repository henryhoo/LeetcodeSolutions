//this solution is not pass, still need some work on it
public class Solution {
    public String simplifyPath(String path) {
        Queue<String> stack = new LinkedList<String>();
        int i = 0;
        while(i<path.length()){
            if(path.charAt(i)=='.'){
                i++;
                if(path.charAt(i)!=null&&path.charAt(i)=='.'){
                    stack.poll();
                    i++;
                }
                
            }
            if(path.charAt(i)!=null&&path.charAt(i)=='/'){
                i++;
            }
            else{
                StringBuilder sb = new StringBuilder();
                while(path.charAt(i)!=null&&path.charAt(i)!='/'){
                sb.append(path.charAt(i));
                i++;}
                stack.offer(sb.toString());
            }
        }
        if(stack.peek()==null){
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        while(stack.peek()!=null){
            sb.append("/");
            sb.append(stack.poll());
        }
        return sb.toString();
        
    }
}
