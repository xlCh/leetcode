//获取rowIndex处的vector
//有更加简单的方法

vector<int> getRow(int rowIndex) {
        vector<int> innerVec;
        for(int i=0; i<rowIndex+1; i++) {
            if(i == 0) {
                innerVec.push_back(1);
            }
            else if(i == 1) {
                innerVec.clear();
                innerVec.push_back(1);
                innerVec.push_back(1);
            }
            else {
                vector<int> temp;
                temp.push_back(1);
                for(int i=0; i<innerVec.size()-1; i++) {
                    temp.push_back(innerVec[i]+innerVec[i+1]);
                }
                temp.push_back(1);
                innerVec = temp;
            }
        }
        return innerVec;
    }
