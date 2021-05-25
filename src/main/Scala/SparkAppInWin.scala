import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SparkSession._
import org.apache.spark.sql.types._
object SparkAppInWin {
def main(args:Array[String]): Unit ={
  //val conf=new SparkConf().setAppName("My App").setMaster("local")
  //val sc=new SparkContext(conf)
  val spark=SparkSession.builder().appName("My App DataFrame").master("local[*]").getOrCreate()
  spark.sparkContext.setLogLevel("Error")
  val data=spark.sparkContext.parallelize(List(1,2,3,4,5))
  val out=data.filter(_>2)
  val df=spark.read.format("csv").option("inferSchema","true")
  .option("sep",",").option("header","true").csv("C:\\Users\\Admin\\Desktop\\docs\\SparkData.txt")
  df.printSchema()
  df.show()
  val  wordcount=df.groupBy("Name").sum("ID")
  wordcount.show()
  import spark.implicits._
  case class p(name:String,ID:String)
  val myData=Array(Row("MyName","1"),Row("Myname2","2")).map(x=>p(x(0).toString,x(1).toString))
  val schema=StructType(Array(StructField("Name1",StringType,true),StructField("ID1",IntegerType,true)))



   // val manualData=spark.createDataset("myData",schema).as[p]


}
}
