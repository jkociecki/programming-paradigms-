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

let modifiedPascal n = 
  let ar = Array.make (2 * n + 1) 1 in
  for i = 1 to n do
    let prev1 = ref ar.(0) in
    let prev2 = ref ar.(1) in
    for j = 2 to i * 2 - 2 do
      let current = ar.(j) in
      ar.(j) <- !prev1 + !prev2 + ar.(j);
      prev1 := !prev2;
      prev2 := current; 
    done;
  done;
  ar;;

  let (+=) ar1 ar2 = 
  if Array.length ar1 < Array.length ar2 then raise(Invalid_argument "diffrent sizes")
  else
    for i = 0 to (Array.length ar1) - 1 do 
      ar1.(i) <- ar2.(i) + ar1.(i);
    done;
  ar1;;


