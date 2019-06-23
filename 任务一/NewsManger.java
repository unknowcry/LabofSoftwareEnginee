/************************************************************************
*
* @description: the main
*
* @author:      unknowcry
* @date:        2019.06.01
*
* @last modified author:
* @last modified date:
*
* @ copyright unknowcry
*
*************************************************************************/
package text;
import java.util.Scanner;             //输入的头文件
class News                            //定义定一个名为News的类
{   //定义5个私有变量
	private  int newside;               
	private String  newstitle;
	private String  newscontent;
	private String newsauthor;
	private boolean isavailable;
	//设置变量newside信息
	public void setnewside(int n)
	{	
		newside=n;
	}
	//设置变量newstitle信息
	public void setnewstitle(String nt)
	{
		newstitle=nt;
	}
	//设置变量newscontent信息
	public void setnewscontent(String nc)
	{
		newscontent= nc;
	}
	//设置变量newsauthor信息
	public void setnewsauthor(String ns)
	{
		newsauthor=ns;
	}
	//设置变量isavailable信息
	public void setisavailable(boolean is)
	{
		isavailable=is;
	}
	//读取变量newside
	public int getnewside()
	{
		return newside;
	}
	//读取变量newstitle
	public String getnewstitle()
	{
		return newstitle;
	}
	//读取变量newscontent
	public String getnewscontent()
	{
		return newscontent;
	}
	//读取变量newsauthor
	public String getnewsauthor()
	{
		return newsauthor;
	}
	//读取变量isavailable
	public boolean getisavailable()
	{
		return isavailable;
	}
	//定义一个无参的构造函数，用来初始化
	public News()
	{
		newside=0;
		newstitle="xxx";
		newscontent="xxx";
		newsauthor="xxx";
		isavailable=false;
	}
   //定义一个有参的构造函数
	public  News(int Snewside,String  Snewstitle,String  Snewscontent,
			String Snewsauthor)
	{
		newside=Snewside;
		newstitle=Snewstitle;
		newscontent=Snewscontent;
		newsauthor=Snewsauthor;
		isavailable=true;
	}
	
}
//定义一个名为NewsManger的类来执行功能
public class NewsManger 
{
	public  static  void main(String[] args) //主函数
	{
		// TODO Auto-generated method stub
		News []N=new News[10];              //定义一个长度为10的数组来储存新闻信息
		Scanner in=new Scanner(System.in);  //通过定义in来给变输入值
    	for(int i=0;i<5;i++)                //循环储存5条信息
    	{
    	int newside=i+1;
    	String newstitle="标题 ： 第 "+(i+1)+"条新闻";
    	String newscontent="内容："+in.nextLine();//储存新闻内容
    	String newsauthor="作者：刘校言";
    	N[i]=new News(newside,newstitle,newscontent,newsauthor);
    	}
    	for(int i=5;i<10;i++)
    	{
    		N[i]=new News();
    	}
  //用do循环来重复操作界面
do  {	
	//显示操作界面
	    System.out.println("*************************************");
    	System.out.println("石家庄铁道大学软件工程系新闻管理系统");
    	System.out.println("1.显示新闻信息");
    	System.out.println("2.增加新闻信息");
    	System.out.println("3.删除新闻信息");
    	System.out.println("4.修改新闻信息");
    	System.out.println("5.查询新闻信息");
    	System.out.println("*************************************");
    	System.out.println("请选择");
     	int n=in.nextInt();//定义一个n用来执行switch
    	switch(n)//switch选择
    	{
    	case 1:
    	{
    		{
    	    shownews(N);//显示新闻
    		}
    	}break;
    	case 2:{	
       addNews(N);//添加新闻
    	}break;
    	case 3:{ 
    		deletenews(N);//删除新闻
    	}break;
    	case 4:{
    	  updatenews(N);//修改新闻
    	}break;
    	case 5:{
    	 seleNews(N);//查询新闻
    	}break;
	}
 }while(true);
    }    
static void shownews(News N[])//显示新闻函数
	{
	for(int i=0;i<10;i++)
	{
		System.out.println(N[i].getnewside()+"  "+N[i].getnewstitle()+"  "+
	N[i].getnewscontent()+"  "+N[i].getnewsauthor()+"  "
				+N[i].getisavailable());
	}
	}
static  void deletenews(News N[])
{
	Scanner in=new Scanner(System.in);
	System.out.println("请输入要删除的新闻号");
	int w=in.nextInt();
	for(int i=0;i<10;i++)
	{
	  if(w==N[i].getnewside())
	  {
		 for(int j=w-1;j<10;j++) 
		{
			 N[j].setnewside(N[j].getnewside());  
			 N[j].setnewstitle(N[j].getnewstitle());
			 N[j].setnewscontent(N[j+1].getnewscontent());
			 N[j].setnewsauthor(N[j+1].getnewsauthor());
			 if(N[j].getisavailable()==false)
			 {
				N[j-1] =new News();
				break;
			 }
		}
	  }
	}
		
}
static  void updatenews(News N[])
{
	Scanner in=new Scanner(System.in);
	System.out.println("输入修改新闻号");
	int w=in.nextInt();
	for(int i=0;i<5;i++)
	{
		if(w==N[i].getnewside())
		{
	    //String sc="内容："+in.nextLine();
		//N[i].setnewscontent(sc);
			
			N[i].setisavailable(false);
		}
	}
}
static  void seleNews(News N[])
{
	Scanner in=new Scanner(System.in);
	System.out.println("输入查询新闻号");
	int cd=in.nextInt();
	for(int i=0;i<10;i++)
	{
	if(cd==N[i].getnewside())
	{
		System.out.println(N[i].getnewside()+"  " +N[i].getnewstitle()+"  " 
				+N[i].getnewscontent()+"  "+
				N[i].getnewsauthor()+"  "+ N[i].getisavailable());
	}
	}
}
static  void addNews(News N[])//添加新闻函数
{
	Scanner in=new Scanner(System.in);
	System.out.println("请输入要添加的新闻个数，内容");
	int b=5;
	int cd=in.nextInt();
	for(int i=b;i<cd+5;i++)//for循环添加内容
	{
		int newside=i+1;
		String newstitle="标题 ：第 "+(i+1)+"条新闻";
    	String newscontent="内容："+in.nextLine();//储存新闻内容
    	String newsauthor="作者 ：刘校言";
    	//通过构造函数来把值输入进去
    	N[i]=new News(newside,newstitle,newscontent,newsauthor);
	b=b+cd;
}
}
}