package goodsdao;

import java.io.IOException;
import java.sql.SQLException;

public class Test {
public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
	//ִ�����ݿ⵼�����
		//GoodsSaveDAO goodsdao=new GoodsSaveDAO();
		//goodsdao.savegoods(new GoodsService().goodsgeter("goods.txt"));
	//ִ�����ݿ⵼������
	GoodsService goodsput=new GoodsService();
	goodsput.goodsputservice(new GoodsPutDAO().putgoods());
}
}
