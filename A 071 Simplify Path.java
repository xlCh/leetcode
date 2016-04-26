//https://leetcode.com/problems/simplify-path/
//路径的化简

public String simplifyPath(String path) {
        Stack<String> paths = new Stack<String>();
        int i=0;
        while(i < path.length()) {
            if(path.charAt(i) == '/') {
                String str = "";
                while(i < path.length() && path.charAt(i) == '/') {
                    i++;
                }
                while(i != path.length() && path.charAt(i) != '/') {
                    str += path.charAt(i);
                    i++;
                }
                if(str.equals("."))
                    continue;
                else if(str.equals("..")) {
                    if(!paths.isEmpty())
                        paths.pop();
                }
                else if(!str.equals(""))
                    paths.push(str);
            }
        }
        String result = "";
        while(!paths.isEmpty()) {
            result = '/' + paths.pop() + result;
        }
        return result.equals("")?"/":result;
    }
