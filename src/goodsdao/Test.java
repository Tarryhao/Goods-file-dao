package goodsdao;

import java.io.IOException;
import java.sql.SQLException;

public class Test {
public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
	//执行数据库导入操作
		//GoodsSaveDAO goodsdao=new GoodsSaveDAO();
		//goodsdao.savegoods(new GoodsService().goodsgeter("goods.txt"));
	//执行数据库导出操作
	GoodsService goodsput=new GoodsService();
	goodsput.goodsputservice(new GoodsPutDAO().putgoods());
}
}
