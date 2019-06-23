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
import java.util.Scanner;             //�����ͷ�ļ�
class News                            //���嶨һ����ΪNews����
{   //����5��˽�б���
	private  int newside;               
	private String  newstitle;
	private String  newscontent;
	private String newsauthor;
	private boolean isavailable;
	//���ñ���newside��Ϣ
	public void setnewside(int n)
	{	
		newside=n;
	}
	//���ñ���newstitle��Ϣ
	public void setnewstitle(String nt)
	{
		newstitle=nt;
	}
	//���ñ���newscontent��Ϣ
	public void setnewscontent(String nc)
	{
		newscontent= nc;
	}
	//���ñ���newsauthor��Ϣ
	public void setnewsauthor(String ns)
	{
		newsauthor=ns;
	}
	//���ñ���isavailable��Ϣ
	public void setisavailable(boolean is)
	{
		isavailable=is;
	}
	//��ȡ����newside
	public int getnewside()
	{
		return newside;
	}
	//��ȡ����newstitle
	public String getnewstitle()
	{
		return newstitle;
	}
	//��ȡ����newscontent
	public String getnewscontent()
	{
		return newscontent;
	}
	//��ȡ����newsauthor
	public String getnewsauthor()
	{
		return newsauthor;
	}
	//��ȡ����isavailable
	public boolean getisavailable()
	{
		return isavailable;
	}
	//����һ���޲εĹ��캯����������ʼ��
	public News()
	{
		newside=0;
		newstitle="xxx";
		newscontent="xxx";
		newsauthor="xxx";
		isavailable=false;
	}
   //����һ���вεĹ��캯��
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
//����һ����ΪNewsManger������ִ�й���
public class NewsManger 
{
	public  static  void main(String[] args) //������
	{
		// TODO Auto-generated method stub
		News []N=new News[10];              //����һ������Ϊ10������������������Ϣ
		Scanner in=new Scanner(System.in);  //ͨ������in����������ֵ
    	for(int i=0;i<5;i++)                //ѭ������5����Ϣ
    	{
    	int newside=i+1;
    	String newstitle="���� �� �� "+(i+1)+"������";
    	String newscontent="���ݣ�"+in.nextLine();//������������
    	String newsauthor="���ߣ���У��";
    	N[i]=new News(newside,newstitle,newscontent,newsauthor);
    	}
    	for(int i=5;i<10;i++)
    	{
    		N[i]=new News();
    	}
  //��doѭ�����ظ���������
do  {	
	//��ʾ��������
	    System.out.println("*************************************");
    	System.out.println("ʯ��ׯ������ѧ�������ϵ���Ź���ϵͳ");
    	System.out.println("1.��ʾ������Ϣ");
    	System.out.println("2.����������Ϣ");
    	System.out.println("3.ɾ��������Ϣ");
    	System.out.println("4.�޸�������Ϣ");
    	System.out.println("5.��ѯ������Ϣ");
    	System.out.println("*************************************");
    	System.out.println("��ѡ��");
     	int n=in.nextInt();//����һ��n����ִ��switch
    	switch(n)//switchѡ��
    	{
    	case 1:
    	{
    		{
    	    shownews(N);//��ʾ����
    		}
    	}break;
    	case 2:{	
       addNews(N);//�������
    	}break;
    	case 3:{ 
    		deletenews(N);//ɾ������
    	}break;
    	case 4:{
    	  updatenews(N);//�޸�����
    	}break;
    	case 5:{
    	 seleNews(N);//��ѯ����
    	}break;
	}
 }while(true);
    }    
static void shownews(News N[])//��ʾ���ź���
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
	System.out.println("������Ҫɾ�������ź�");
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
	System.out.println("�����޸����ź�");
	int w=in.nextInt();
	for(int i=0;i<5;i++)
	{
		if(w==N[i].getnewside())
		{
	    //String sc="���ݣ�"+in.nextLine();
		//N[i].setnewscontent(sc);
			
			N[i].setisavailable(false);
		}
	}
}
static  void seleNews(News N[])
{
	Scanner in=new Scanner(System.in);
	System.out.println("�����ѯ���ź�");
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
static  void addNews(News N[])//������ź���
{
	Scanner in=new Scanner(System.in);
	System.out.println("������Ҫ��ӵ����Ÿ���������");
	int b=5;
	int cd=in.nextInt();
	for(int i=b;i<cd+5;i++)//forѭ���������
	{
		int newside=i+1;
		String newstitle="���� ���� "+(i+1)+"������";
    	String newscontent="���ݣ�"+in.nextLine();//������������
    	String newsauthor="���� ����У��";
    	//ͨ�����캯������ֵ�����ȥ
    	N[i]=new News(newside,newstitle,newscontent,newsauthor);
	b=b+cd;
}
}
}