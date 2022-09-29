import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'menuFilter'
})
export class MenuFilterPipe implements PipeTransform {

  transform(value: any): any {

    const result = [];
    
    for (const i of value) {
      if (i['availability'] == "yes") {
        result.push(i);
      }
    }
    return result;
  }

}
