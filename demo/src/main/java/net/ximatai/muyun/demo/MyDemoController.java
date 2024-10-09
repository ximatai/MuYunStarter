package net.ximatai.muyun.demo;

import io.quarkus.runtime.Startup;
import jakarta.ws.rs.Path;
import net.ximatai.muyun.base.BaseScaffold;
import net.ximatai.muyun.database.builder.Column;
import net.ximatai.muyun.database.builder.TableWrapper;

@Startup
@Path(DemoConst.BASE_PATH + "/test")
public class MyDemoController extends BaseScaffold {

    @Override
    public String getMainTable() {
        return "demo";
    }

    @Override
    public void fitOut(TableWrapper wrapper) {
        wrapper
                .setPrimaryKey(Column.ID_POSTGRES)
                .addColumn(Column.of("v_name").setType("varchar"))
                .addColumn(Column.of("t_create").setDefaultValue("now()"));
    }

}
