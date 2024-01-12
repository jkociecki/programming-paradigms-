module type MEMORY = 
sig 
  type memory
  val init : int -> memory
  val get : memory -> int -> int option
  val set : memory -> int * int option -> unit
  val dump : memory -> int option list
end;;

module ArrayMemory : MEMORY = 
struct
  type memory = { myarray : int option array }
  let init n = { myarray = Array.make n None } 
  let get mem index = mem.myarray.(index)
  let set mem (index, value) = mem.myarray.(index) <- value
  let dump mem = Array.to_list mem.myarray
end;; 

module ListMemory : MEMORY = 
struct
  type memory = { mutable mylist : int option list } 
  let init n = { mylist = List.init (n + 1) (fun _ -> None) }
  let get mem index = List.nth mem.mylist index
  let set mem (index, value) = mem.mylist <- List.mapi (fun i x -> if i = index then value else x) mem.mylist
  let dump mem = mem.mylist 
end;;

module ListMemory2 = 
  struct
    type memory = { mylist : int option list ref }
    let init n = { mylist = ref (List.init n (fun _ -> None)) }
    let get mem index = List.nth !(mem.mylist) index
    let set mem (index, value) = mem.mylist := List.mapi (fun i x -> if i = index then value else x) !(mem.mylist)
    let dump mem = !(mem.mylist) 
  end
  
module RamMachine = functor (M : MEMORY) ->
struct
  type instruction = Load of int * int | Sum of int * int * int | Sub of int * int * int | Mul of int * int * int
  type ram_machine = { memory : M.memory; mutable instructions : instruction list }
  let init size instructions = {memory = M.init size; instructions}

  let step machine = 
    match machine.instructions with 
    | [] -> ()
    | instruction :: rest -> 
        match instruction with 
        | Load(index, value) -> 
            (M.set machine.memory (index, Some value); machine.instructions <- rest)

        | Sum(index, x, y) ->
            (match (M.get machine.memory x, M.get machine.memory y) with 
               (Some val1, Some val2) -> (M.set machine.memory (index, Some(val1 + val2)); machine.instructions <- rest)
             | _ -> ()
            )
        | Sub(index, x, y) ->
            (match (M.get machine.memory x, M.get machine.memory y) with 
               (Some val1, Some val2) -> (M.set machine.memory (index, Some(val1 - val2)); machine.instructions <- rest)
             | _ -> ()
            )

        | Mul(index, x, y) ->
            (match (M.get machine.memory x, M.get machine.memory y) with 
               (Some val1, Some val2) -> (M.set machine.memory (index, Some(val1 * val2)); machine.instructions <- rest)
             | _ -> ()
            ) 
             

  let dump machine = M.dump machine.memory;
end;;


module MyRamMachine = RamMachine(ArrayMemory)
let initial_machine = MyRamMachine.init 10 [Load(1, 7); Load(2, 3); Sum(0, 1, 2); Sub(0, 0, 2); Load(3, 10); Sum(3, 3, 0); Mul(3,3,3)];;
MyRamMachine.step initial_machine;;
MyRamMachine.dump initial_machine;;
MyRamMachine.step initial_machine;;
MyRamMachine.dump initial_machine;;
MyRamMachine.step initial_machine;;
MyRamMachine.dump initial_machine;;
MyRamMachine.step initial_machine;;
MyRamMachine.dump initial_machine;;
MyRamMachine.step initial_machine;;
MyRamMachine.dump initial_machine;;
MyRamMachine.dump initial_machine;;
MyRamMachine.step initial_machine;;
MyRamMachine.dump initial_machine;;
MyRamMachine.step initial_machine;;
MyRamMachine.dump initial_machine;;
MyRamMachine.dump initial_machine;;
MyRamMachine.step initial_machine;;
MyRamMachine.dump initial_machine;;
MyRamMachine.step initial_machine;;
MyRamMachine.dump initial_machine;;