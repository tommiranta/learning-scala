enum Grade:
  case Bad, Mediocre, Inadequate, Passable, Good, VeryGood, Excellent

object Grade:
  /** @return
    *   The median grade of a collection of grades.
    *
    * The median grade can be computed by sorting the collection and taking the
    * element in the middle. If there are an even number of grades, any of the
    * two grades that are just before or after the middle of the sequence are
    * correct median values.
    *
    * Grades can be compared by using their `ordinal` method.
    *
    * Hints: use the following operations:
    *   - `sortBy` and `ordinal` to sort the collection of grades,
    *   - `size` to compute the number of elements,
    *   - `apply` to select an element at a specific index.
    */
  def median(grades: Seq[Grade]): Grade =
    // grades.sortBy(Grade.ordinal)
    grades.length match {
      case 1 => grades(0)
      case 2 => grades(0)
      case _ => grades.sortBy(g => g.ordinal).apply(grades.length / 2)
    }

end Grade

case class Candidate(name: String)
case class Ballot(grades: Map[Candidate, Grade])

case class Election(description: String, candidates: Set[Candidate])
val grades =
  List(Grade.Mediocre)
// val med = Grade.median(grades)
grades.length / 2

val tiramisu = Candidate("Tiramisu")
val cremeBrulee = Candidate("Crème brûlée")
val cheesecake = Candidate("Cheesecake")

val election = Election("Best dessert", Set(tiramisu, cremeBrulee, cheesecake))

val ballot1 = Ballot(
  Map(
    tiramisu -> Grade.Excellent,
    cremeBrulee -> Grade.Good,
    cheesecake -> Grade.Inadequate
  )
)

val ballot2 = Ballot(
  Map(
    tiramisu -> Grade.Excellent,
    cremeBrulee -> Grade.Passable,
    cheesecake -> Grade.Good
  )
)

val ballot3 = Ballot(
  Map(
    tiramisu -> Grade.VeryGood,
    cremeBrulee -> Grade.Inadequate,
    cheesecake -> Grade.Good
  )
)

val elected = Seq(ballot1, ballot2, ballot3)
val flat = elected.flatMap(ballot => ballot.grades)
val gradesPerCandidate: Map[Candidate, Seq[Grade]] =
  flat.groupMap(_._1)(_._2)
