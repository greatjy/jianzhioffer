package com.baidu.char6;

public class TestNumber
{
    public static void main(String[] args)
	{		
		double hx_hy = (xinxiShang(0.7)+xinxiShang(0.3))*2;
		double hxy = xinxiShang(0.5)+2*xinxiShang(0.2)+xinxiShang(0.1);
		double Ixy = hx_hy - hxy;
		System.out.println(hx_hy+" "+hxy);
		System.out.println(hx_hy - hxy);
		double hx_hz = xinxiShang(0.4)+xinxiShang(0.3)+xinxiShang(0.2)+xinxiShang(0.1);
		double hz = xinxiShang(0.6)+xinxiShang(0.4);
		double hy_hz = xinxiShang(0.5) + 2*xinxiShang(0.2)+xinxiShang(0.1);
		double hx_hy_hz = xinxiShang(0.3) + 2*xinxiShang(0.2)+3*xinxiShang(0.1);
		System.out.println(hx_hz+" "+hz+" "+hy_hz+" "+hx_hy_hz);
		double Ixy_z = hx_hz - hz - hx_hy_hz + hy_hz;
		System.out.println(Ixy_z);
		double cr = (Ixy_z-Ixy)/hx_hy*2;
		System.out.println(cr+"cratio of x1 和 x7");
		double hy = xinxiShang(0.7)+xinxiShang(0.3);
		double Iyz = hy + hz - hy_hz;
		System.out.println(Iyz);
		double DRj = (hx_hz + hy - hx_hy_hz) * 0.021111;
		System.out.println(DRj);
		double[] pi = {0.3,0.3,0.4};
		System.out.println(getEntropy(pi));
	}
    public static double myLog(int base,double index)
    {
    	double n1 = Math.log10(base);
    	double n2 = Math.log10(index);
    	return n2/n1;
    }
    public static double xinxiShang(double pi)
    {
    	return pi * myLog(2, 1.0/pi);
    }
    public static double getEntropy(double[] pi)
    {
    	if(pi == null || pi.length == 0)
    		return 0.0;
    	double ans = 0;
    	double sum = 0;
    	for(int i=0;i<pi.length;i++)
    	{
    		ans += pi[i]*myLog(2, 1.0/pi[i]);
    		sum += pi[i];
    	}
    	if(Math.abs(sum - 1)>1e-2)
    	{
    		throw new RuntimeException("输入数组之和不为1");
    	}
    	return ans;
    }
}
