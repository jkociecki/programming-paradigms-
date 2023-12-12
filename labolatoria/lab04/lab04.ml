(*zadanie 1*)
type point2D = float * float;;

let distance (point1 : point2D) (point2 : point2D) =
  let x1, y1 = point1 in
  let x2, y2 = point2 in
  sqrt(((y1 -. y2) ** 2.) +. (x1 -. x2) ** 2.)
;;

distance (0., 0.) (1., 1.);;
distance (2., 3.5) (4.2, 1.8);;
  
type pointN = float list

let rec distanceN point1 point2 =
  let square_diff a b = (a -. b) ** 2.0 in
  let rec sum_of_squares acc list1 list2 =
    match list1, list2 with
    | [], [] -> acc
    | x1::rest1, x2::rest2 -> sum_of_squares (acc +. square_diff x1 x2) rest1 rest2
    | _, _ -> invalid_arg "different dimensions"
  in
  sqrt (sum_of_squares 0.0 point1 point2)
;;

(*zadanie 2*)
type person = {
  first_name : string;
  second_name : string;
  age : int;
  gender : string;
  shoe_size : int;
}
;;

type partnership = {
   person1 : person;
   person2 : person
}

let younger_partner (partners : partnership) =
  if partners.person1.age <= partners.person2.age then
    partners.person1
  else
    partners.person2
;;

let p1 = {
   first_name = "Jan";
   second_name = "Kowalski";
   age = 30;
   gender = "Men";
   shoe_size = 43;
}

let p2 = {
   first_name = "Anna";
   second_name = "Nowak";
   age = 18;
   gender = "Women";
   shoe_size = 38;
}

let partners = {
person1 = p1;
person2 = p2;
};;

younger_partner partners;;
type person_tuple = string * string * int * string * int;;
type partnership_tuple = person_tuple * person_tuple;;

let younger_person_tuple (partners : partnership_tuple) = 
   match partners with
   (partner1, partner2) ->
      let (_,_,age1,_ , _) = partner1 in
      let (_, _, age2, _, _) = partner2 in
   if age1 <= age2 then partner1 else partner2
;;

younger_person_tuple (("Jan", "Kowalski", 40, "male", 43), ("Anna", "Nowak", 18, "female", 38));;

(*zadanie 3*)
type week_day = Monday |Tuesday |Wednesday |Thursday |Friday |Saturday |Sunday

let to_string_day (day: week_day) = 
   match day with
    Monday -> "Poniedzialek"
   |Tuesday -> "Wtorek"
   |Wednesday -> "Sroda"
   |Thursday -> "Czwartek"
   |Friday -> "Piatek"
   |Saturday -> "Sobota"
   |Sunday -> "Niedziela"
;;

let next_day (day: week_day) =
   match day with   
    Monday -> Tuesday
   |Tuesday -> Wednesday
   |Wednesday -> Thursday
   |Thursday -> Friday
   |Friday -> Saturday
   |Saturday -> Sunday
   |Sunday -> Monday
;;

to_string_day (next_day Friday);;

(*zadanie 4*)
type 'a maybe =
  | Nothing
  | Just of 'a
;;

let safeHead list =
  match list with
  | [] -> Nothing
  | head :: _ -> Just head
;;

let myList1 = [1;2;3;4;5;6]
let myList2 = []
let myList3 = ["s1", "s2", "s3"];;

let res1 = safeHead myList1
let res2 = safeHead myList2
let res3 = safeHead myList3

(*zadanie 5*)

type solid_figure =
  | Cuboid of float * float * float  
  | Cone of float * float           
  | Sphere of float                
  | Cylinder of float * float       


let volume : solid_figure -> float = 
  let pi = 4. *. atan 1.0 in
  function
  | Cuboid (length, width, height) -> length *. width *. height
  | Cone (radius, height) -> (pi *. radius *. radius *. height) /. 3.0
  | Sphere radius -> (4.0 *. pi *. radius *. radius *. radius) /. 3.0
  | Cylinder (radius, height) -> pi *. radius *. radius *. height

type solid_figure2 =
  | Cuboid of {a : float; b : float; h : float}
  | Cone of {h : float; r : float}
  | Sphere of {r : float}
  | Cylinder of {r : float; h : float}

let volumeOfFigure (figure : solid_figure2) = 
   let pi = 4. *. atan 1.0 in
   function
   | Cuboid {a; b; h} -> a *. b *. h
   | Cone {h; r} -> pi *. (1. /. 3.) *. (r ** 2.)
   | Sphere {r} -> (4. /. 3.) *. (r ** 3.) *. pi
   | Cylinder {r; h} -> pi *. (r ** 2.) *. h
