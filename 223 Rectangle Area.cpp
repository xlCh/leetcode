//根据坐标给出两个矩形，求共同区域（非交，而是并）

int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = (C-A)*(D-B), area2 = (G-E)*(H-F);
        if(C<E || G<A || D<F || H<B)
            return area1 + area2;
        int down = B>F?B:F, up = D>H?H:D, left = A>E?A:E, right = C>G?G:C;
        return area1 + area2 - (up-down)*(right-left);
    }
