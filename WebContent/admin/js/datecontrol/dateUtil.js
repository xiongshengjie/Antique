function getNextMonthDate(v)
{
	 var today = new Date(v);
	 today.setMonth(today.getMonth()+1);
	 if(today.getMonth()+1<10)
	 	return today.getFullYear()+'-0'+(today.getMonth()+1);
	 else
	 	return today.getFullYear()+'-'+(today.getMonth()+1);
}

function getDate(v)
{
	var month=Number(v.substr(5,2));
	var year=Number(v.substr(0,4));
	if(month==12)
	   year+=1;
	var d=new Date();
	d.setMonth(month);
	d.setFullYear(year);
	 if(d.getMonth()+1<10)
	 	return d.getFullYear()+'-0'+(d.getMonth()+1);
	 else
	 	return d.getFullYear()+'-'+(d.getMonth()+1);
}