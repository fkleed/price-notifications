package changelog

databaseChangeLog = {
    changeSet(id: '1', author: 'liquibase') {
        createTable(tableName: 'test_table') {
            column(name:'test_id', type="int") {
                constraints(primaryKey: true)
            }
            column(name:'test_column', type="int")
        }
    }
}