//判断括号的闭合情况：(), [], {}
bool isValid(string s) {
        stack<char> st;
        for(int i=0; i<s.length(); i++)
        {
            if(s.at(i) == '(' || s.at(i) == '{' || s.at(i) == '[')
            {
                st.push(s.at(i));
            }
            else if(st.empty())
                return false;
            else
            {
                char character = st.top();
                st.pop();
                if((s.at(i) == ')' && character == '(') || (s.at(i) == '}' && character == '{') || (s.at(i) == ']' && character == '['))
                    continue;
                else
                    return false;
            }
        }
        if(st.empty())
            return true;
        else
            return false;
    }
