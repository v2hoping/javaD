package com.owl.zookeeper.use.ioc;

/**
 * Created by wanghouping on 2018/5/14.
 *
 * @author houping wang
 */
public class Student {
        private String name;
        private String add;

        public void selfIntroDuction(){
            System.out.println("我的姓名是 " + name + " 我来自 " + add);

        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAdd() {
            return add;
        }

        public void setAdd(String add) {
            this.add = add;
        }
}
