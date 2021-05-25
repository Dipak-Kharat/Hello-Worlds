import BinarySearch.AnotherMe

object BinarySearch {
  /*def BinarySearchRec(arr: Array[Int], Element_to_Search: Int, start: Int, end: Int): Int = {
  {

    if (start > end)
      return -1
    var mid = start + (end - start) / 2

    if (arr(mid) == Element_to_Search)
      return mid
    else if (arr(mid) > Element_to_Search)
      return BinarySearchRec(arr, Element_to_Search, start, (mid-1))
    else
      return BinarySearchRec(arr, Element_to_Search, (mid+1), end)
  }*/

  def AnotherMe(arr: Array[Int], elemnt: Int, start1: Int, end1: Int): Int = {

    if (start1 > end1)
      return -1
    var mid = start1 + (end1 - start1) / 2

    if (arr(mid) == elemnt)
      return mid
    else if (arr(mid) > elemnt)
      return AnotherMe(arr, elemnt, start1, (mid - 1))
    else
      return AnotherMe(arr, elemnt, (mid - 1), end1)

  }


  def main(args: Array[String]) {
    val searchElement = 10
    val sortedArray = Array(1, 4, 9, 10, 16, 22, 26, 29, 32, 36)
    val secondSortedArray = Array(1, 2, 3, 4, 5, 6,7)
    var myelem = AnotherMe(secondSortedArray, searchElement, 0, secondSortedArray.length - 1)
    if (myelem == -1)
      print("Not founf")
    else
      print("fund at location" + myelem)
    //var elementIndex = BinarySearchRec(sortedArray, searchElement, 0, 6);

    /*if(elementIndex == -1)
      print("Not Found")
    else
      print("Element found at index value " + elementIndex)
  */

  }

}