 
function setClock() {
  const now = new Date();
  const seconds = now.getSeconds();
  const minutes = now.getMinutes();
  const hours = now.getHours();

  const secondHand = document.querySelector('.second-hand');
  const minuteHand = document.querySelector('.minute-hand');
  const hourHand = document.querySelector('.hour-hand');

  // Calculate the degrees for each hand
  const secondsDegrees = (seconds / 60) * 360 ;
  const minutesDegrees = (minutes / 60) * 360 ;
  const hoursDegrees = ((hours % 12) / 24) * 360 + 90;

  // Set the rotation of each hand
  secondHand.style.transform = `rotate(${secondsDegrees}deg)`;
  minuteHand.style.transform = `rotate(${minutesDegrees}deg)`;
  hourHand.style.transform = `rotate(${hoursDegrees}deg)`;
}

// Update the clock every second
setInterval(setClock, 1000);
// Initialize the clock immediately v
setClock();