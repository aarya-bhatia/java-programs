function f(x) {
  return (7 * Math.cos(6 * x)) / x;
}

function getDx(a, b, n) {
  return (b - a) / n;
}

function roundTo(x, places) {
  const e = Math.pow(10, places);
  return Math.round(x * e) / e;
}

function Trapezoid(start, end, intervals, f) {
  const dx = getDx(start, end, intervals);
  let sum = f(start) + f(end);
  for (let i = start + dx; i < end; i += dx) {
    y = 2 * f(i);
    console.log("[Trapezoid]: f(" + i + ") = " + y);
    sum += y;
  }
  return roundTo((sum * dx) / 2, 6);
}

function Simpsons(start, end, intervals, f) {
  const dx = getDx(start, end, intervals);
  let sum = f(start) + f(end);
  for (let i = start + dx, counter = 0; i < end; i += dx, counter++) {
    let y;
    if (counter % 2 == 0) {
      y = 4 * f(i);
    } else {
      y = 2 * f(i);
    }
    console.log("[Simpsons]: f(" + i + ") = " + y);
    sum += y;
  }
  return roundTo((sum * dx) / 3, 6);
}

function Midpoint(start, end, intervals, f) {
  const dx = getDx(start, end, intervals);
  let sum = 0;
  for (let i = start + dx / 2; i < end; i += dx) {
    const y = f(i);
    console.log("[Midpoint]: f(" + i + ") = " + y);
    sum += y;
  }
  return roundTo(sum, 6);
}

function main() {
  //   console.log(Trapezoid(1, 5, 4, f));
  //   console.log(Simpsons(1, 5, 4, f));
  //   console.log(Midpoint(1, 5, 4, f));
  console.log(
    Trapezoid(0, 20, 10, (x) => {
      return 6 * Math.cos(7 * Math.PI * x);
    })
  );
}

main();
