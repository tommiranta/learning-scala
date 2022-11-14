import scala.collection.mutable
import todo.data.*
import todo.PersistentModel.*

val test = mutable.HashMap((1, "valll"), (2, "vol"))
test.remove(1)

val defaultTasks = List(
  Id(0) -> Task(
    State.completedNow,
    "Complete Effective Scala Week 2",
    None,
    List(Tag("programming"), Tag("scala"))
  ),
  Id(1) -> Task(
    State.Active,
    "Complete Effective Scala Week 3",
    Some("Finish the todo list exercise"),
    List(Tag("programming"), Tag("scala"), Tag("encapsulation"), Tag("sbt"))
  ),
  Id(2) -> Task(
    State.Active,
    "Make a sandwich",
    Some("Cheese and salad or ham and tomato?"),
    List(Tag("food"), Tag("lunch"))
  )
)

val idStore: mutable.LinkedHashMap[Id, Task] =
  mutable.LinkedHashMap.from(defaultTasks)

// val allTags: List[Tag] =
idStore.flatMap(task => task._2.tags).toSet.toList

idStore.filter(task => task._2.tags.find(x => x == Tag("food")) != None)

idStore.filter(task => task._1 != Id(1))

val t = Task(State.Active, "Foo", None, List.empty)
t.complete

idStore.get(Id(2)).get.complete

Tasks(idStore.toList.filter(task => task._1 != Id(0)))

saveTasks(Tasks(defaultTasks))
delete(Id(2))
// complete(Id(1))
read(Id(1))
clear()
