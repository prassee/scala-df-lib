import org.dflib.DataFrame
import java.util.stream.IntStream
import org.dflib.Printers
import org.dflib.csv.Csv

object Main:
  def main(args: Array[String]): Unit =
    println(evalDf())
    evalCsv()

  def evalDf(): String =
    val df1 =
      DataFrame
        .foldByRow("a", "b", "c")
        .ofStream(IntStream.range(1, 10))
        .rows(row => row.getInt(1) > 0)
        .select()
    Printers.tabular.toString(df1)
    
  def evalCsv(): Unit = 
    val x = Printers.tabular.toString(Csv.load(this.getClass.getResource("./customer.csv").getPath()))
    println(x)
