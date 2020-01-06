package com.gf.thread;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
 
public class Driver {
	public final static int M = 10000; //���峣��������A������
	public final static int K = 10000; //���峣��������A������������B������
	public final static int N = 10000; //���峣��������B������
	final static int NUM_THREADS = 2; //���峣�����߳�����
	private static int [][]A; //����A
	private static int [][]B; //����B
	private static int [][]C; //����C
	//---------------------
	//�����๹�췽��
	public Driver(){
		A=new int[M][K];
		B=new int[K][N];
		C=new int[M][N]; //A��B��C��ʼ��
		fillRandom(A); //��0-99���������ʼ������A
		fillRandom(B); //��0-99���������ʼ������B
		for(int i = 0;i < M; i++)
			for(int j = 0; j < N; j++)
				C[i][j] =  0;//��C����ȫ����		
	}
	
	//-------------------
	//��ʼ������������0-99���������ʼ������A��B
	private void fillRandom(int[][] A) {
		for(int i= 0; i<A.length; i++){
			for(int j = 0; j<A[i].length; j++)
				A[i][j] = (int)(Math.random()*100);
		}
	}
	
	//--------------------
	//���о���˷�����
	public static void singleThread(){
		for(int i = 0; i < M; i++){
			for(int j = 0; j < N;j++){
				for(int k = 0;k < K; k++)
					C[i][j] += A[i][k]*B[k][j];
			}
		}
	}
	
	//----------------------
	//main����
	public static void main(String[] args){
		new Driver();//�½�һ�����������
		
		//�����������C����λ����Ϣ�����ں�����֤���ַ����������Ƿ���ȷ
		int []rol = new int[3];
		int []col = new int[3];
		for(int i = 0; i < rol.length; i++){
			rol[i]  =(int)(Math.random()*M);
			col[i] = (int)(Math.random()*N);
		}
		
		
		
		
		//---------------------------------
		//����һ������Ҳ����ֱ�ӽ�������
		for(int i = 0; i < M; i++)
			for(int j = 0; j < N; j++)
				C[i][j] = 0;//��C����ȫ����	
		long time3 = System.currentTimeMillis();//��¼��ʼʱ��
		singleThread();//���ô��м��㺯��
		long time4 = System.currentTimeMillis();//��¼����ʱ��
		//��ӡ����һʹ�õ�ʱ��;���C�������λ�õ�ֵ
		System.out.println("����["+M+","+K+"]��["+K+","+N+"]�׾���˷�,ֱ�Ӽ�����ʱ:"+(time4-time3)+"����");
		System.out.println(C[rol[0]][col[0]]+" "+C[rol[1]][col[1]]+" "+C[rol[2]][col[2]]);
		System.out.println();
		
		
		
		//--------------------------------
		//������:����(4�߳�)�����������ĸ������̣߳�ÿ���߳���ɾ���˷������1/4����
        Thread[] workers = new Thread[NUM_THREADS];
		for(int i = 0;i < NUM_THREADS; i++)
			workers[i] = new Thread(new WorkThread(i,A,B,C));//�����ĸ������߳�
		long time1 = System.currentTimeMillis();//��¼��ʼʱ��
		for(int i = 0; i<NUM_THREADS;i++){
			workers[i].start();//�����ĸ������߳�
		}
		for(int i = 0; i < NUM_THREADS; i++){
			try{
				workers[i].join();//�ȴ���ǰ�߳�ִ�н���
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		long time2 = System.currentTimeMillis();//��¼����ʱ��
		//��ӡ������ʹ�õ�ʱ��;���C�������λ�õ�ֵ
		System.out.println("����["+M+","+K+"]��["+K+","+N+"]�׾���˷�,����("+NUM_THREADS+"�߳�)��ʱ:"+(time2-time1)+"����");
		System.out.println(C[rol[0]][col[0]]+" "+C[rol[1]][col[1]]+" "+C[rol[2]][col[2]]);
		System.out.println();
		
		
		
		//------------------------------
		//��������ʹ���̳߳ط�����������
		for(int i = 0; i < M; i++)
			for(int j = 0; j < N; j++)
				C[i][j] = 0;//��C����ȫ����	
		//�����ĸ������߳�
		Thread []poolThreads = new Thread[NUM_THREADS];
		for(int i = 0;i < NUM_THREADS;i++)
			poolThreads[i] = new Thread(new WorkThread(i,A,B,C));
		//�����̳߳�
		ExecutorService pool = Executors.newCachedThreadPool();
		long time5 = System.currentTimeMillis();//��¼��ʼʱ��
		for(int i = 0; i < NUM_THREADS; i++)
			pool.execute(poolThreads[i]);//���ĸ������̷߳����̳߳���ִ��
		pool.shutdown();//���̳߳���ֹǰ����ִ����ǰ�ύ������
		while (true) {  
            if (pool.isTerminated()) {   
                break;  
            }
        }//��һ����ѭ���ж��̳߳��Ƿ�ִ�����
		long time6 = System.currentTimeMillis();//��¼����ʱ��
		//��ӡ������ʹ�õ�ʱ��;���C�������λ�õ�ֵ
		System.out.println("����["+M+","+K+"]��["+K+","+N+"]�׾���˷�,�̳߳ؼ�����ʱ:"+(time6-time5)+"����");
		System.out.println(C[rol[0]][col[0]]+" "+C[rol[1]][col[1]]+" "+C[rol[2]][col[2]]);
	}
}

