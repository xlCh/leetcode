//https://leetcode.com/problems/pascals-triangle/
//Pascal's Triangle 传入行数，返回如下格式
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//]
//代码行数略多 待优化

vector<vector<int>> generate(int numRows) {
        vector<vector<int>> outerVec;
        vector<int> innerVec;
        for(int i=0; i<numRows; i++) {
            if(i == 0) {
                innerVec.push_back(1);
                outerVec.push_back(innerVec);
            }
            else if(i == 1) {
                innerVec.clear();
                innerVec.push_back(1);
                innerVec.push_back(1);
                outerVec.push_back(innerVec);
            }
            else {
                vector<int> temp;
                temp.push_back(1);
                for(int i=0; i<innerVec.size()-1; i++) {
                    temp.push_back(innerVec[i]+innerVec[i+1]);
                }
                temp.push_back(1);
                outerVec.push_back(temp);
                innerVec = temp;
            }
        }
        return outerVec;
    }

//JAVA代码 可优化几行
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(numRows < 1)
            return result;
        List<Integer> first = new ArrayList<Integer>();
        first.add(1);
        result.add(first);
        for(int i=1; i<numRows; i++) {
            result.add(generateNext(result.get(i-1)));
        }
        return result;
    }
    
    public List<Integer> generateNext(List<Integer> now) {
        List<Integer> next = new ArrayList<Integer>();
        next.add(now.get(0));//可放入循环 直接add 1
        int nowSize = now.size();
        for(int i=1; i<nowSize; i++) {
            next.add(now.get(i) + now.get(i-1));
        }
        next.add(now.get(nowSize-1)); //可放入循环 直接add 1
        return next;
    }
