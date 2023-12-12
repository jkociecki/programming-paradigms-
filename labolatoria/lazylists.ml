type 'a llist = LNil | Cons of 'a * (unit -> 'a llist);;

let rec lfrom k = Cons (k, function () -> lfrom (k+1));;

let rec getEverySecond l_list = 
  match l_list with
   | LNil -> LNil
   | Cons(x, fx) -> 
      match fx() with
        Cons(y, fy) -> Cons(x, function () -> getEverySecond (fy()))
      | LNil -> LNil;;




let rec ltake (n, lxs) = 
  match (n, lxs) with
  | (0, _ ) -> []
  | (_, LNil) -> [] 
  | (n, Cons(x, fx)) -> x :: ltake (n-1, fx());;

let rec merge list1 list2 = 
  match list1 with
  | LNil -> LNil
  | Cons(x, fx) -> Cons(x, function () -> merge list2 (fx()));;
  

let merged = merge (lfrom 10) (lfrom 100);;
let everysnd = getEverySecond (lfrom 0);;
let res = ltake(20, everysnd);;
