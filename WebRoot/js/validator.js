(function (window, undefined) {
    /* Eui 命名空间  */

    var _Eui = window.Eui,

        Eui = {};

    /*
    * 工具包
    */
    Eui.util = {
    		//判断日期格式
    		isDate: function ( date, fmt ) { 
    			if (fmt==null) 
    				fmt="MM-dd-yyyy"; 
    			var yIndex = fmt.indexOf("yyyy"); 
    			if(yIndex==-1) 
    				return false; 
    			var year = date.substring(yIndex,yIndex+4); 
    			var mIndex = fmt.indexOf("MM"); 
    			if(mIndex==-1) 
    				return false; 
    			var month = date.substring(mIndex,mIndex+2); 
    			var dIndex = fmt.indexOf("dd"); 
    			if(dIndex==-1) 
    				return false; 
    			var day = date.substring(dIndex,dIndex+2); 
    			if(Eui.util.isNumber(year) && year>"2100" && year< "1900") 
    				return false; 
    			if(Eui.util.isNumber(month)&&month>"12" && month< "01") 
    				return false; 
    			if(Eui.util.isNumber(day) && day>Eui.util.getMaxDay(year,month) && day< "01") 
    				return false; 
    			return true; 
    			},
    		
    	getMaxDay: function (year,month) { 
    			if(month==4||month==6||month==9||month==11) 
    				return "30"; 
    			if(month==2) 
    			if(year%4==0&&year%100!=0 || year%400==0) 
    				return "29"; 
    			else 
    				return "28"; 
    			return "31"; 
    			},
    			
    	isNumber: function ( s ){   
    		var regu = "^[0-9]+$"; 
    		var re = new RegExp(regu); 
    		if (s.search(re) != -1) { 
    			return true; 
    		} else { 
    			return false; 
    		} 
    	}, 

    		
    	checkMobile: function ( s ){   
    		var regu =/^[1][3][0-9]{9}$/; 
    		var re = new RegExp(regu); 
    		if (re.test(s)) { 
    			return true; 
    		}else{ 
    			return false; 
    		} 
    	},
        // 字符串去除空格
        trim: function (str) {
            return str.replace(/\s+/g, '');
        },

        // 字符串左边去除空格
        trimLeft: function (str) {
            return str.replace(/^\s+/g, '');
        },
       
        // 字符串右边去除空格
        trimRight: function (str) {
            return str.replace(/\s+$/g, '');
        },

        addClass: function (elem, name) {
            if (!Eui.util.hasClass(elem, name)) {
                elem.className += ' ' + name;
            }
        },

        removeClass: function (elem, name) {
            if (Eui.util.hasClass(elem, name)) {
                elem.className = elem.className.replace(name, '');
            }
        },

        hasClass: function (elem, name) {
            return elem.className.indexOf(name) > -1;
        },

        addEvent: function (elem, type, handler) {
            if (elem.addEventListener) {
                elem.addEventListener(type, handler, false);
            } else if (elem.attachEvent) {
                elem.attachEvent('on' + type, handler);
            } else {
                elem['on' + type] = handler;
            }
        },

        getEvent: function (e) {
            return e ? e : window.event;
        },

        preventDefault:function(e){
            if(e.preventDefault){
                e.preventDefault();
            }else{
                event.returnValue = false;
            }
        },

        noConflict: function () {
            window.Eui = _Eui;
        }
    };

    window.Eui = Eui;
})(window);


(function($){
    /*
    * class RequiredValidator
    * 验证组件，用于验证表单域值的必填项
    */
    function RequiredValidator(message) {  // implements validate
        this.message = message || 'cannot be empty';
        this.valid = false;
    }
    RequiredValidator.prototype = {
        validate: function (value) {
            value = $.util.trim(value);

            if (!value) {
                this.valid = false;
            } else {
                this.valid = true;
            }
        },

        getValid: function () {
            return this.valid;
        },

        getMessage: function () {
            return this.message;
        }
    };

    /*
    * class MinLengthValidator
    * 验证组件，用于验证表单域值的是否小于最小值
    */
    function MinLengthValidator(length, message) {
        this.message = (message || 'the lenth should bigger than ') + length + '......';
        this.valid = false;
        this.length = length;
    }
    MinLengthValidator.prototype = {
        validate: function (value) {
            value = $.util.trimLeft(value);
            value = $.util.trimRight(value);

            if (value.length < this.length) {
                this.valid = false;
            } else {
                this.valid = true;
            }
        },

        getValid: function () {
            return this.valid;
        },

        getMessage: function () {
            return this.message;
        }
    };

    /*
    * class MaxLengthValidator
    * 验证组件，用于验证表单域值的是否大于最大值
    */
    function MaxLengthValidator(length, message) {
        this.message = (message || 'the length should shorter than ') + length + '......';
        this.valid = false;
        this.length = length;
    }
    MaxLengthValidator.prototype = {
        validate: function (value) {
            value = $.util.trimLeft(value);
            value = $.util.trimRight(value);

            if (value.length > this.length) {
                this.valid = false;
            } else {
                this.valid = true;
            }
        },

        getValid: function () {
            return this.valid;
        },

        getMessage: function () {
            return this.message;
        }
    };
    
    /*
     * class MaxLengthValidator
     * 验证组件，用于验证表单域值的日期格式是否正确
     */
     function DateValidator(message) {
         this.message = message || 'please input the legal date';
         this.valid = false;
     }
     DateValidator.prototype = {
         validate: function (value) {
    	 	
             if ($.util.isDate(value,"MM-dd-yyyy")) {
                 this.valid = true;
             } else {
            	this.valid = false;
             }
         },

         getValid: function () {
             return this.valid;
         },

         getMessage: function () {
             return this.message;
         }
     };
    
    
    /*
     * class MaxLengthValidator
     * 验证组件，用于验证表单域值的是否是电话号码格式
     */
     function PhoneValidator(message) {
         this.message = message || 'please input the legal phone';
         this.valid = false;
     }
     PhoneValidator.prototype = {
         validate: function (value) {
    	 	
             if ($.util.checkMobile(value)) {
                 this.valid = true;
             } else {
            	this.valid = false;
             }
         },

         getValid: function () {
             return this.valid;
         },

         getMessage: function () {
             return this.message;
         }
     };
     
     /*
      * class MaxLengthValidator
      * 验证组件，用于验证表单域值的是否是正整数格式
      */
      function IsNumberValidator(message) {
          this.message = message || 'please input the legal number';
          this.valid = false;
      }
      IsNumberValidator.prototype = {
          validate: function (value) {
     	 	
              if ($.util.isNumber(value)) {
                  this.valid = true;
              } else {
             	this.valid = false;
              }
          },

          getValid: function () {
              return this.valid;
          },

          getMessage: function () {
              return this.message;
          }
      };

    /*
    * class PasswordValidator
    * 验证组件，用于验证表单域的前后密码是否一致
    */
    function PasswordValidator(message) {
        this.message = message || 'different passwords input';
        this.valid = false;
    }
    PasswordValidator.prototype = {
        validate: function (value) {
            var value1 = $.util.trimLeft(value.val1);
            value1 = $.util.trimRight(value1);
            var value2 = $.util.trimLeft(value.val2);
            value2 = $.util.trimRight(value2);

            if (value1 !== value2) {
                this.valid = false;
            } else {
                this.valid = true;
            }
        },

        getValid: function () {
            return this.valid;
        },

        getMessage: function () {
            return this.message;
        }
    };

    /*
    * class EmailValidator
    * 验证组件，用于验证表单域的email值是否有效
    */
    function EmailValidator(message) {
        this.message = message || '请输入完整的电子邮件。';
        this.valid = false;
    }
    EmailValidator.prototype = {
        validate: function (value) {
            value = $.util.trimLeft(value);
            value = $.util.trimRight(value);

            var pattern = /^[\w\-]+@[\w\-]+(\.[a-zA-Z0-9\-]+)+$/gi;
            if (!pattern.test(value)) {
                this.valid = false;
            } else {
                this.valid = true;
            }
        },

        getValid: function () {
            return this.valid;
        },

        getMessage: function () {
            return this.message;
        }
    };


    /*
    * class FieldsValidator
    * 表单元素的具体类，使用所有的验证组件对表单元素进行验证
    */
    function FieldsValidator(fields, rules, messages) {
        // 表单元素列表， 如果只有一个， 则为单元素
        this.fields = fields; 

        // 规则列表
        this.rules = $.util.trim(rules).split(',');

        // 验证组件列表
        this.validators = [];

        // 验证状态
        this.valid = false;

        // 错误信息元素
        this.errorElem = null;

        this.init(messages);

        this.addEvents();
    }
    FieldsValidator.prototype = {
        addEvents:function(){
            var that = this;
            for(var i = 0, len = this.fields.length; i < len; i ++){
                var field = this.fields[i];
                $.util.addEvent(field,'focus',function () {
                    that.hideError();
                });
                $.util.addEvent(field,'blur',function () {
                    that.validate();
                });
            }
        },

        validate: function () {
            var val = '',
                i = 0,
                len = this.fields.length;

            // 取出表单元素最可能的有效值
            for (; i < len; i++) {
                if(this.fields[i].type === 'checkbox' || this.fields[i].type === 'radio'){
                    if(this.fields[i].checked){
                        val = this.fields[i].value;
                        break;
                    }
                } else{
                    val = this.fields[i].value;
                    var valTrim = $.util.trim(val);
                    if (valTrim) {
                       break;
                    }
                }
            }
            
            var i = 0,
                value; 
            while (this.validators[i]) {
                // 对于密码验证，需要重置value的值
                if (this.validators[i] instanceof PasswordValidator) {
                    value = {
                        val1: this.fields[0].value,
                        val2: this.fields[1].value
                    }
                } else {
                    value = val;
                }

                // 调用验证组件进行验证
                this.validators[i].validate(value);

                // 取得验证状态结果
                this.valid = this.validators[i].getValid();

                // 如果验证未通过，停止验证，并显示当前验证错误信息
                if (!this.valid) {
                    this.showError(this.validators[i].getMessage());
                    return;
                }

                i++;
            }

            // 验证通过
            this.valid = true;
            this.hideError();
        },

        getValid: function () {
            return this.valid;
        },

        // 显示错误信息
        showError: function (message) {
            if (!this.errorElem) {
                this.errorElem = document.createElement('span');
                this.errorElem.className = 'validator-message';
                this.fields[this.fields.length - 1].parentNode.appendChild(this.errorElem, this.fields[this.fields.length - 1].nextSibling);
                
                for(var i = 0, len = this.fields.length; i < len; i ++){
                    var field = this.fields[i];
                    $.util.addClass(field, 'validator-error');
                }
            }

            this.errorElem.innerHTML = message;
        },

        // 取消错误信息
        hideError: function () {
            if (this.errorElem) {
                this.fields[this.fields.length - 1].parentNode.removeChild(this.errorElem);
                this.errorElem = null;

                for(var i = 0, len = this.fields.length; i < len; i ++){
                    var field = this.fields[i];
                    $.util.removeClass(field, 'validator-error');
                }
            }
        },

        // 初始化，根据所有需要验证的规则，建立验证组件
        init: function (messages) {
            var patternMin = /minlength\((\d+)\)/,
                patternMax = /maxlength\((\d+)\)/;

            var i = 0;
            while (this.rules[i]) {
                var rule = this.rules[i];

                if (rule === 'required') {
                    this.validators.push(new RequiredValidator(!!messages ? messages.requiredMsg : null));
                }

                if (patternMin.test(rule)) {
                    var length = RegExp.$1;
                    this.validators.push(new MinLengthValidator(length, !!messages ? messages.minLengthMsg : null));
                }

                if (patternMax.test(rule)) {
                    var length = RegExp.$1;
                    this.validators.push(new MaxLengthValidator(length, !!messages ? messages.maxLengthMsg : null));
                }

                if (rule === 'password') {
                    this.validators.push(new PasswordValidator(!!messages ? messages.passwordMsg : null));
                }

                if (rule === 'email') {
                    this.validators.push(new EmailValidator(!!messages ? messages.emailMsg : null));
                }
                
                if(rule ==='phone'){
                	this.validators.push(new PhoneValidator(!!messages ? messages.phoneMsg : null));
                }
                
                if(rule === 'isnumber'){
                	this.validators.push(new IsNumberValidator(!!messages ? messages.isnumberMsg : null));
                }
                
                if(rule === 'date'){
                	this.validators.push(new DateValidator(!!messages ? messages.dateMsg : null));
                }

                i++;
            }
        }
    };


    /*
    * class Validator
    *
    * 表单验证类, 表单验证的入口 
    * 每个需要验证的元素拥有一个FieldsValidator
    */
    function Validator(form, fields, messages) {
        this.fieldValidators = [];
        this.form = form;
        this.fieldElems = [];
        this.valids = [];

        // 提取表单元素列表和规则列表，并为每一个元素建立验证组件
        for (var i = 0; !!fields[i]; i++) {
            var names = $.util.trim(fields[i].name).split(','),
                fieldElems = [],
                rules = fields[i].rules;

            for (var j = 0, len = names.length; j < len; j++) {
                fieldElems.push(form.elements[names[j]]);
            }

            this.fieldValidators.push(new FieldsValidator(fieldElems, rules, messages));
        }

        this.addEvents();
    }
    Validator.prototype = {
        validate: function () {
            for (var i = 0; !!this.fieldValidators[i]; i++) {
                this.fieldValidators[i].validate();
                this.valids[i] = this.fieldValidators[i].getValid();
            }
        },

        addEvents: function () {
            var that = this;
            $.util.addEvent(this.form, 'submit', function (e) {
                that.validate();
                e = $.util.getEvent(e);

                for(var i = 0, len = that.valids.length; i < len ; i++){
                    if (!that.valids[i]) {
                       $.util.preventDefault(e);
                       break;
                    }
                }
                
            });
        }
    };

    Eui.Validator = Validator;
})(Eui);

