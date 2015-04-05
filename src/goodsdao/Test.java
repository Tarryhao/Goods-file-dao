package goodsdao;

import java.io.IOException;
import java.sql.SQLException;

public class Test {
public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
	GoodsDAO goodsdao=new GoodsDAO();
	goodsdao.savegoods(new GoodsService().goodsgeter("goods.txt"));
}
}
