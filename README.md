# Calculator

This is a basic and simple arithmetic calculator that supports the following operations:

- Addition
- Subtraction
- Multiplication
- Division

## Preview

![Preview](./assets/preview.jpg)

## How it works

This application is using [Shunting Yard](<https://en.wikipedia.org/wiki/Shunting_yard_algorithm#:~:text=In%20computer%20science%2C%20the%20shunting,abstract%20syntax%20tree%20(AST).>) Algorithm
to parse arithmetic or logical expression and convert it to [Reverse Polish Notation](https://en.wikipedia.org/wiki/Reverse_Polish_notation) then evalute the expression. The implementation
can be seen in [ArithmeticParser.kt](./app/src/main/java/com/alturino/calculator/ArithmeticParser.kt).

## Related Leetcode Question

- [150. Reverse Polish Notation](https://leetcode.com/problems/evaluate-reverse-polish-notation)
- [224. Basic Calculator](https://leetcode.com/problems/basic-calculator)

## License

This project is licensed under the License. See the [LICENSE](./LICENSE) file for details.

```
Copyright 2024 Ricky "onirutlA" Alturino

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
