import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'staffFilter'
})
export class StaffFilterPipe implements PipeTransform {

  transform(value: any): any {
    const result = [];
    
    for (const i of value) {
      if (i['role'] == "staff") {
        result.push(i);
      }
    }
    return result;
  }
  

}
