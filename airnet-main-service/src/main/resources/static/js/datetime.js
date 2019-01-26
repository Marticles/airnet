
/*******************************************/
// Basic Date Range Picker
/*******************************************/
$('.daterange').daterangepicker();

/*******************************************/
// Date & Time
/*******************************************/
$('.datetime').daterangepicker({
    timePicker: true,
    timePickerIncrement: 30,
    locale: {
        format: 'MM/DD/YYYY h:mm A'
    }
});

/*******************************************/
//Calendars are not linked
/*******************************************/
$('.timeseconds').daterangepicker({


    timePicker: true,
    timePickerIncrement: 30,
    timePicker24Hour: true,
    timePickerSeconds: true,
    startDate: new Date(),
    endDate: new Date(),
    locale:{
        "format": 'YYYY-MM-DD HH:mm:ss',
        "separator": " - ",
        "applyLabel": "确定",
        "cancelLabel": "取消",
        "fromLabel": "起始时间",
        "toLabel": "结束时间'",
        "customRangeLabel": "自定义",
        "weekLabel": "W",
        "daysOfWeek": ["日", "一", "二", "三", "四", "五", "六"],
        "monthNames": ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
        "firstDay": 1
    },
});

/*******************************************/
// Single Date Range Picker
/*******************************************/
$('.singledate').daterangepicker({
    singleDatePicker: true,
    showDropdowns: true
});

/*******************************************/
// Auto Apply Date Range
/*******************************************/
$('.autoapply').daterangepicker({
    autoApply: true,
});

/*******************************************/
// Calendars are not linked
/*******************************************/
$('.linkedCalendars').daterangepicker({
    linkedCalendars: false,
});

/*******************************************/
// Date Limit
/*******************************************/
$('.dateLimit').daterangepicker({
    dateLimit: {
        days: 7
    },
});

/*******************************************/
// Show Dropdowns
/*******************************************/
$('.showdropdowns').daterangepicker({
    showDropdowns: true,
});

/*******************************************/
// Show Week Numbers
/*******************************************/
$('.showweeknumbers').daterangepicker({
    showWeekNumbers: true,
});

/*******************************************/
// Date Ranges
/*******************************************/
$('.dateranges').daterangepicker({
    ranges: {
        'Today': [moment(), moment()],
        'Yesterday': [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
        'Last 7 Days': [moment().subtract(6, 'days'), moment()],
        'Last 30 Days': [moment().subtract(29, 'days'), moment()],
        'This Month': [moment().startOf('month'), moment().endOf('month')],
        'Last Month': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
    }
});

/*******************************************/
// Always Show Calendar on Ranges
/*******************************************/
$('.shawCalRanges').daterangepicker({
    ranges: {
        'Today': [moment(), moment()],
        'Yesterday': [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
        'Last 7 Days': [moment().subtract(6, 'days'), moment()],
        'Last 30 Days': [moment().subtract(29, 'days'), moment()],
        'This Month': [moment().startOf('month'), moment().endOf('month')],
        'Last Month': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
    },
    alwaysShowCalendars: true,
});

/*******************************************/
// Top of the form-control open alignment
/*******************************************/
$('.drops').daterangepicker({
    drops: "up" // up/down
});

/*******************************************/
// Custom button options
/*******************************************/
$('.buttonClass').daterangepicker({
    drops: "up",
    buttonClasses: "btn",
    applyClass: "btn-info",
    cancelClass: "btn-danger"
});

/*******************************************/
// Language
/*******************************************/
$('.localeRange').daterangepicker({
    ranges: {
        "Aujourd'hui": [moment(), moment()],
        'Hier': [moment().subtract('days', 1), moment().subtract('days', 1)],
        'Les 7 derniers jours': [moment().subtract('days', 6), moment()],
        'Les 30 derniers jours': [moment().subtract('days', 29), moment()],
        'Ce mois-ci': [moment().startOf('month'), moment().endOf('month')],
        'le mois dernier': [moment().subtract('month', 1).startOf('month'), moment().subtract('month', 1).endOf('month')]
    },
    locale: {
        applyLabel: "Vers l'avant",
        cancelLabel: 'Annulation',
        startLabel: 'Date initiale',
        endLabel: 'Date limite',
        customRangeLabel: 'SÃ©lectionner une date',
        // daysOfWeek: ['Dimanche', 'Lundi', 'Mardi', 'Mercredi', 'Jeudi', 'Vendredi','Samedi'],
        daysOfWeek: ['Di', 'Lu', 'Ma', 'Me', 'Je', 'Ve', 'Sa'],
        monthNames: ['Janvier', 'fÃ©vrier', 'Mars', 'Avril', 'ÐœÐ°i', 'Juin', 'Juillet', 'AoÃ»t', 'Septembre', 'Octobre', 'Novembre', 'Decembre'],
        firstDay: 1
    }
});

$('#mdate').bootstrapMaterialDatePicker({
    weekStart: 0,
    time: false
});
$('#timepicker').bootstrapMaterialDatePicker({
    format: 'HH:mm',
    time: true,
    date: false
});
$('#date-format').bootstrapMaterialDatePicker({
    format: 'dddd DD MMMM YYYY - HH:mm'
});

$('#min-date').bootstrapMaterialDatePicker({
    format: 'DD/MM/YYYY HH:mm',
    minDate: new Date()
});
// Clock pickers
$('#single-input').clockpicker({
    placement: 'bottom',
    align: 'left',
    autoclose: true,
    'default': 'now'
});
$('.clockpicker').clockpicker({
    donetext: 'Done',
}).find('input').change(function () {
    console.log(this.value);
});
$('#check-minutes').click(function (e) {
    // Have to stop propagation here
    e.stopPropagation();
    input.clockpicker('show').clockpicker('toggleView', 'minutes');
});
if (/mobile/i.test(navigator.userAgent)) {
    $('input').prop('readOnly', true);
}
// Date Picker
jQuery('.mydatepicker, #datepicker').datepicker();
jQuery('#datepicker-autoclose').datepicker({
    autoclose: true,
    todayHighlight: true
});
jQuery('#date-range').datepicker({
    toggleActive: true
});
jQuery('#datepicker-inline').datepicker({
    todayHighlight: true
});
// Daterange picker
$('.input-daterange-datepicker').daterangepicker({
    buttonClasses: ['btn', 'btn-sm'],
    applyClass: 'btn-danger',
    cancelClass: 'btn-inverse'
});
$('.input-daterange-timepicker').daterangepicker({
    timePicker: true,
    format: 'MM/DD/YYYY h:mm A',
    timePickerIncrement: 30,
    timePicker12Hour: true,
    timePickerSeconds: false,
    buttonClasses: ['btn', 'btn-sm'],
    applyClass: 'btn-danger',
    cancelClass: 'btn-inverse'
});
$('.input-limit-datepicker').daterangepicker({
    format: 'MM/DD/YYYY',
    minDate: '06/01/2015',
    maxDate: '06/30/2015',
    buttonClasses: ['btn', 'btn-sm'],
    applyClass: 'btn-danger',
    cancelClass: 'btn-inverse',
    dateLimit: {
        days: 6
    }
});