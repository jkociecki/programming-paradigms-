let rec flatten1 list=
    if list = [] then []
    else List.hd list @ flatten1(List.tl list);;

let list = [[5;6];[1;2;3]];;
flatten1 list;;

let rec count(list, element) =
    if list = [] then 0
    else 
      if List.hd list = element then 1 + count(List.tl list, element)
      else count(List.tl list, element);;

let list2 = ['a'; 'b'; 'a'; 'c'];;
count(['a'; 'b'; 'a'; 'c'], 'a');;

let rec replicate(element, n) =
  if n = 0 then []
  else element :: replicate(element, n - 1);;

replicate("la", 3);;

let rec sqrList list = 
  if list = [] then []
  else 
    let head = List.hd list in head * head :: sqrList(List.tl list);;

let myList = [2; -2; 6; 9; 7];;    
sqrList myList;;

let palindrome list = 
  let rec reverse result list = 
    if list = [] then result
    else reverse ((List.hd list) :: result) (List.tl list) in
  list = reverse [] list;;
    
let myList = [1;2;3;2;1];;
palindrome myList;;

let rec listLength list = 
  if list = [] then 0
  else 1 + listLength(List.tl list);;
