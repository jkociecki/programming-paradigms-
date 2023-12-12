let reverse4(a, b, c, d) = (d, c, b, a);;
reverse4(1, 3.5, false, "string");;


let rec sumProd s e = 
  if s >= e then raise(Invalid_argument "s < e")
  else if (s + 1) = e then (s, s)
  else 
   let (sum, prod) = (s + fst(sumProd (s+1) e), s * snd(sumProd (s+1) e))
   in (sum, prod);;

sumProd 5 10;;
sumProd (-4) 0;;
sumProd 10 2;;


let isPerfect number = 
  if number <= 0 then raise(Invalid_argument "n > 0")
  else if number = 1 then false
  else let rec inner number_ = 
      if number_ = 2 then 1
      else if number mod (number_ - 1) = 0 then (number_ - 1) + inner (number_ - 1)
      else inner (number_ - 1)
  in number = inner number;;

isPerfect 496;;
isPerfect 78;;
isPerfect (-2);;


let rec insert list element index = 
  if list = [] then [element]
  else if index <= 0 then element :: list
  else List.hd list :: insert (List.tl list) element (index - 1);;

let myList = [0;1;2;3;4;5;6;7;8;9];;
insert myList 777 (-10);;
insert myList 777 (5);;
insert myList 777 (0);;
insert myList(20);;



let rec choice list1 list2 = 
    if list1 = [] && list2 = [] then []
    else if list1 = [] then List.hd list2 :: choice [] (List.tl list2)
    else if list2 = [] then List.hd list1 :: choice (List.tl list1) []
    else 
      if List.hd list1 > List.hd list2 then List.hd list1 :: choice (List.tl list1) (List.tl list2)
      else List.hd list2 :: choice (List.tl list1) (List.tl list2);;

let myList1 = [1;5;3;8];;
let myList2 = [2;7;4;8;9];;


let squish lists =
  let rec flatten lists = 
  if lists = [] then []
  else if List.hd lists = [] then
    flatten (List.tl lists)
  else List.hd (List.hd lists) :: flatten (List.tl (List.hd lists) :: List.tl lists)  in 
 if lists = [] then [] else flatten lists

let list = [[5;6];[1;2;3]];;
let list1 = [[5;6];[1;2;3];[2;2;2]];;
let list2 = [[1;2;3]];;
let list3 = [[];[]];;
squish list;;
squish list1;;
squish list2;;
squish list3;;



let rec squish lst =
  let rec append_list list1 list2 =
    if list1 = [] then list2
    else (List.hd list1) :: append_list (List.tl list1) list2
  in
  if lst = [] then []
  else append_list (List.hd lst) (squish (List.tl lst))
;;

let exampleList = [[1; 5; 3; 8]; [2; 7; 4; 1]; []; [9]];;
let exampleList1 = [[1; 5; 3; 8]; [2; 7; 4; 1]; [7;3;2]; [9]];;
let exampleList2= [[1; 5; 3; 8]];;
let exampleList3 = [];;

let res = squish exampleList;;
let res = squish exampleList1;;
let res = squish exampleList2;;



