package goodsdao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GoodsService {
	public ArrayList<Goods> goodsgeter(String filename) throws IOException{
		ArrayList<Goods> list=new ArrayList<Goods>();
		
		FileReader fr=new FileReader(filename);
		BufferedReader br=new BufferedReader(fr);
		String line="";
		while((line=br.readLine())!=null){
			String[] date=line.split("��");//���ݣ��ָ��ֶ�
			
			Goods goods=new Goods();//�Ȱ�ȡ����ֵ���������
			goods.setGoodsname(date[0]);
			goods.setPrice(Double.valueOf(date[1]));
			goods.setDate(date[2]);
			goods.setCompany(date[3]);
			
			list.add(goods);//�Ѷ������ArrayList��
		}
		br.close();
		fr.close();
		return list;
	}
}
