#数据库设计文档
_____________________________
- - - - -----------------------
##SQL文件基本设计
注意sql文件执行后会在数据库中生成一个新的名为travals的数据库，以Naivicat为例，当任选一个sql文件运行，会在数据库以外生成一个名为travals的数据库
—————————————用户——————
#—————————————————————
##表
###用户资料user
*  用户编号 userID varchar(20)*因为是无意义的随机储存的数目，且范围远超2^10，因而用varchar*
* 昵称 nickname varchar(10)
* 身份证号码非空 identyId int(17)(not null)
* 真实姓名 realname varchar(10)（ not null）
* 积分 point int(5)
* 密码password varchar (20) 用以确认安全与否(not null)
* 电话号码phone char (11)
* qq        qq char (20)
#-------------------------
###用户好友 friend
* 用户编号user int(20) 外键连接user.userid
* 好友用户编号user int(20) 外键连接user.userid
###景区 scene
* 景区编号 scenenID varchar(20)
* 景区所在地址city text
#-----------------------
###景点 spot
* 景点编号 spotid varchar(20) 主键
* 景点名称name varchar(20)
* 景区编号 sceneid  varchar(20)外键连接scenen.scenenid
#-------------------------
###浏览记录browsehistory
* 相应用户名称 userid(10)
* 浏览文件编号 textid(10)
#--------------------------
###历史纪录 history
* 用户编号 userid int（10）=user.userid(外键)
* 最近浏览景点=spot.id int (20)
* 最近浏览景区=spot.sceneidint(20)
#-------------------------
###文件信息 notes
* 文件编号（graphID）varchar 20
* 内容1 游记文本信息(content)
* 内容2 评论信息(comment)text
* 名字(monicker)varchar40
* 上传时间(uploadtime)varchar20
* 修改时间(changetim)varchar20
* 上传者（author）=user.userid
* 修改者列表(changer) text
#-------------------------
###路径设计 line
* spotid1 外键，与spot表的spotid
* spotid2外键，与spot表的spotid
* sceneid外键与scenen的scenenId
#-------------------------
###浏览记录browsehistory
* userid int用户记录，
* textid int 用户浏览的文件记录
>以下均为主键
* 景点
*   前驱景点
* 所在景区
-------------------------------------------------------
##视图
###recorder
* userid与user表的useid相对应
* textid与browsehistory的textid对应
##JDBC0.1文档
> 每个包内包含了相应的sql语句用以实现相应的功能
###connect
* 连接类Connect包
  > public static Connection getConnection()构建条件连接,
* vo包*USER表中基本元素与存取函数，结构相同，命名方式相似，故可大体介绍之*
   >private +表内元素，具体件上sql文件设计
  >Set+具体元素，设置改变元素
   >get+具体元素，得到元素值
   >构造(带参数)
   > 构造函数不带参数
* Dao包(封装sql语句的合集类)
     * UserDao类
 >   *select搜索功能*,返回线性表List<User>
          > public static List<User> selectall() 查询user表中所有信息，并返回一个线性表
          > public static List<User> select(String option)，option为需要搜索的项目
          >  public static List<User> select(String option,String conditon)option为需要搜索的仙姑，condition为需要搜索的条件*
 > *delete删除功能*
        > public static void  delete(String condition)condition为需要删除的
 >*update更新添加，修改功能，注意，condition应该是主键* 
       >  public static void Update(String option,int values1,String condition,int values2)
       >   public static void Update(String option,String values1,String condition,int values2)
       >option，condition为更新的内容与更i性能的条件，问题是一次只能更新一次  
   >*insert添加新行*
        >   public static void insert1(User users) 向User表内插入新内容()完整
        >    public static void insert2(User users) 向User表内插入新内容()不完整
     *   NotesDao类  
*select搜索功能*
          > public static List<Notes> selectall() 查询Notes表中所有信息，并返回一个线性表
      
      * Dao类
>   
        


