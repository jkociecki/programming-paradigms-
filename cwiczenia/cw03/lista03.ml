(*zadanie 1*)
let f1 x = x 2 2;;
let f2 x y z = x ( y ^ z );;

(*zadanie 2*)
let curry3 f x y z = f(x, y, z);;
let curry3_1 = function f -> function x -> function y -> function z -> f(x, y, z);;
let uncurry3 f(x, y, z) = f x y z;;
let uncurry3_1 = function f -> function (x, y, z) -> f x y z;;

(*zadanie 3*)
let sumProd list = List.fold_left ( fun (sum, prod) x -> (sum + x, prod * x)) (0, 1) list ;;

 
(*zadanie 4*)
let rec quicksort = function
    [] -> []
  | h::t -> 
      let small = List.filter (fun y -> y < h ) t
      and large = List.filter (fun y -> y >= h ) t
      in quicksort small @ (h :: quicksort large);;

quicksort [2;3;1;6;5;8;9;120;119;3];;

(*zadanie 5*)
let rec insertSort compare list = 
  let rec insertProperly sortedList item = 
    match sortedList with 
    | [] -> [item]
    | h::t -> if compare h item then item :: h :: t
        else h :: insertProperly t item
  in 
  match list with
  | [] -> []
  | h::t -> insertProperly (insertSort compare t) h;;



insertSort (fun x y -> x > y) [3;6;5;1];; 
insertSort (fun x y -> x < y) [23;423;445;2;43;52;62;24;13;51];;
insertSort (fun (k1, _) (k2, _) -> k1 >= k2)[(1, "a"); (3, "b"); (2, "c"); (1, "d")];;

let rec mergeSort compare list = 

  let rec merge l1 l2 = 
    match l1, l2 with 
    | h1::t1, h2::t2 -> 
        if compare h1 h2 then h1 :: merge t1 l2
        else h2 :: merge t2 l1
    | [], l | l, [] -> l  in
  
  let rec split source left rigth = 
    match source with
    | [] -> (left, rigth)
    | h::t -> split t rigth (h :: left) in
  
  match list with 
  | [] | [_] -> list
  | list -> let l, r = split list [] []
      in merge (mergeSort compare l) (mergeSort compare r);;
              
mergeSort (fun x y -> x < y) [12;32;132;13;21312;312;321;31;3; 12; 12; 12];;      

let f1 x y z = x y z;;
let f2 x y = function z -> x::y;;




  


