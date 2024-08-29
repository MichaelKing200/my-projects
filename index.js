function factorial(n) {
    if (n === 0 || n === 1) {
        return 1;
     
     } else {
        return n * factorial(n-1);
     }  
}
console.log(factorial(5));


let age = 30;
age =31;
console.log(age)

let numbers = [1, 2, 3, 4, 5]
console.log(numbers[4]);



let matrix = [
   [1, 2, 3],
   [4, 5, 6],
   [7, 8, 9]
];
console.log(matrix[0][1]);
let greeting = 'Hello, world!';
console.log(greeting.length);

function add(a, b) {
   return a + b;
}
console.log(add(2, 3));

 age = 30;
age = 31;
console.log(age)


// // declaration
// // let age = 30;
// // const PI = 3.14;

 function greet(name) {
  return `Hello, ${name}!`;  
 }
 console.log(greet("Michael"));



// let temperature = 10;

// if (temperature > 30) {
//   console.log ("it's hot!") ;
// }else if (temperature < 20) {
//   console.log("it's warm")
// }else {
//    console.log("it's cold")
// }
for (let i = 1; i <= 9; i++) {
   console.log(i);
}


let number = [1, 2, 3, 4, 5];
let doubled = number.map(num => num * 2);
console.log(doubled);


let even = number. filter(num => num % 2 === 0);
console.log(even);


console.table({name: 'michael', email: 'michaelking2050@gmail.com'})

console.warn('warning');
console.error('alert') 

console.group('examples');
console.warn('warning');
console.error('alert')
console.groupEnd();

const styles = 'padding: 10px; width: 10px; border-radius: 5px; background-color: red; color: white';
console.log('%cHello world', styles);

const firstNanme = 'michael';

console.log(firstNanme, typeof firstNanme);

const s = 'developer';

x = s.length;
x = s.toUpperCase('d')
x = s.replace('d', 'D')
console.log(x)


const odd = numbers.filter(num => num % 2 != 0)
console.log(odd)

const sum = numbers.reduce((total, num) => total + num, 0);
console.log(sum);