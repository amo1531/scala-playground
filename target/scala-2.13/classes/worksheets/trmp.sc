//def pref(s: String, t: String, out: String = ""): String = {
//  println(s"string1: $s, string2: $t and output: $out")
//  if (s == "" || t == "" || s(0) != t(0)) out
//  else pref(s.substring(1), t.substring(1), out + s(0))
//}
//
//println("=====",pref("abcpqr", "abcde"))

def prefixBetter(str1: String, str2: String): (String, String, String) = {


  def loop(str1: String,
           str2: String,
           accumulator: String = "",
           str1Unique: String = "",
           str2Unique: String = ""):(String, String, String) = (str1, str2) match {

    case (_, _) if (str1.isEmpty && str2.isEmpty) => (accumulator, str1Unique, str2Unique)
    case (_, _) if (str1.isEmpty && str2.nonEmpty) =>
      loop(str1, str2.substring(1), accumulator, str1Unique, str2Unique + str2(0))
    case (_, _) if (str1.nonEmpty && str2.isEmpty) =>
      loop(str1.substring(1), str2, accumulator, str1Unique + str1(0), str2Unique)
    case (_, _) if (str1(0) != str2(0)) =>
      loop(str1.substring(1), str2.substring(1), accumulator, str1Unique + str1(0), str2Unique + str2(0))
    case (_, _) =>
      loop(str1.substring(1), str2.substring(1), accumulator + str1(0), str1Unique, str2Unique)
  }
  loop(str1, str2)
}

val str1 = "pizseagtsgevlvwpbshxfwbjijtmslkufgofretehjgpcdedstydokejsnrccnkbruawgjmemfqhwmhjsykrejmmexgrsdlwtaybtnhfcapsylopkthboqkvicgwrvycphqnulnjgfgjlqnhdyfwweyifpxyxrvpnshjrrkmkwrvjjssublanosljhqhppmewuidyqblfcjzkwbhqlljvvcjqthbkpcoquepqzcvbkdlhufbkpiyaqbfblexry"
val str2 = "pizseagtsgevlvwpbshxfwbjijtmslkufgofretehjgpcdedstydokejsnrccnkbruawgjmemfqhwmhjsykrejmmexgrsdlwtaybtnhfcapsylopkthboqkvicgcjkyxxubpbqcycioryppydvmwubupxrjlwrwujsiimvpbgkdugjbpqtodgbzzpsduewwovwlfrarfiuaztmmohagkjzzdcnjytamlzpwpfmhlgsdlwfbluxqllcjxbltbrlhgngvtxyksllhfhhzknesqggfazixcotpwwbjenbglhcbnhgjgyimfvfbcezatumthzrqtvdyirxulfhwylbdhkibmiagdgeerriszbnfxmoxgabaxkgkydrnrrbatjbavwdxjqirqivqweqdxeiiotbfidiemakmzbwszgrgekrlalsmbplumxeqmfrulddmbactyuhdljlhhjvxumpkyyzouybtwxtoyiffrderzmztkcdsbhcij"
val (common, unique1, unique2) = prefixBetter(str1, str2)

println(s"${common.length} $common")
println(s"${unique1.length} $unique1")
println(s"${unique2.length} $unique2")

//println("=====",prefixBetter("abcdefpr", "abcpqr"))
//println("=====",prefixBetter("kitkat", "kit"))
//println("=====",prefixBetter("puppy", "puppy"))


//def prefixBetter(str1: String, str2: String): String = {
//
//
//  def loop(str1: String, str2: String, accumulator: String = ""): String = (str1, str2) match {
//    case (_, _) if (str1.isEmpty || str2.isEmpty || str1(0) != str2(0)) => accumulator
//    case (_, _) => loop(str1.substring(1), str2.substring(1), accumulator + str1(0))
//
//  }
//
//  loop(str1, str2)
//}
