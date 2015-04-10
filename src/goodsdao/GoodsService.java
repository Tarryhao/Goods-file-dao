package goodsdao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * ��Ʒ����������
 * @author asus
 *
 */
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
	public void goodsput() throws ClassNotFoundException, SQLException, IOException{
		ArrayList<Goods> list=new GoodsPutDAO().putgoods();
		new GoodsService().goodsputservice(list);
	}
	public void goodsputservice(ArrayList<Goods> list) throws IOException{
		FileWriter fw=new FileWriter("D:/cope.txt");
		BufferedWriter bw=new BufferedWriter(fw);
		for(int i=0;i<list.size();i++){
			Goods goods=list.get(i);
			String dh=",";
			dh=goods.getGoodsname()+dh+String.valueOf(goods.getPrice())+dh+goods.getDate()+dh+goods.getCompany()+dh;
			bw.write(dh);
			bw.newLine();
			bw.flush();
			
		}
		bw.close();
		fw.close();
	}
}
