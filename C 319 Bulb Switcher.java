//https://leetcode.com/problems/bulb-switcher/
//每次转换对应次数倍数上的灯的状态
//除了平方数，都是成对出现的，最后肯定会被关闭。例如16: 1*16, 2*8, 4*4
public int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
    }
