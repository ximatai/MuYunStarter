package net.ximatai.muyun.demo;

import io.quarkus.runtime.Startup;
import jakarta.ws.rs.Path;
import net.ximatai.muyun.base.BaseScaffold;
import net.ximatai.muyun.core.db.PresetColumn;
import net.ximatai.muyun.database.core.builder.Column;
import net.ximatai.muyun.database.core.builder.ColumnType;
import net.ximatai.muyun.database.core.builder.TableWrapper;

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
                .setPrimaryKey(PresetColumn.ID_POSTGRES)
                .addColumn(Column.of("v_name").setType(ColumnType.VARCHAR))
                .addColumn(Column.of("t_create").setDefaultValue("now()"));
    }

}
